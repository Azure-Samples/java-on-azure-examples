#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
if [[ -z $ACR_NAME ]]; then
export ACR_NAME=acreg$RANDOM
fi
az acr create \
--name $ACR_NAME \
--resource-group $RESOURCE_GROUP \
--sku Basic \
--admin-enabled true

if [[ -z $ACR_PULL_SERVICE_PRINCIPAL_NAME ]]; then
export ACR_PULL_SERVICE_PRINCIPAL_NAME=acr-pull-$RANDOM
export ACR_ID=`az acr show --name $ACR_NAME --query id --output tsv`
export ACR_PULL_SERVICE_PRINCIPAL_PASSWORD=`az ad sp create-for-rbac \
--name $ACR_PULL_SERVICE_PRINCIPAL_NAME \
--scopes $ACR_ID \
--role acrpull \
--query password \
--output tsv`
export ACR_PULL_SERVICE_PRINCIPAL_ID=`az ad sp list \
--display-name $ACR_PULL_SERVICE_PRINCIPAL_NAME \
--query [].appId \
--output tsv`
fi


az group delete --name $RESOURCE_GROUP --yes || true
az ad sp delete --id $ACR_PULL_SERVICE_PRINCIPAL_ID || true

if [[ -z $ACR_PULL_SERVICE_PRINCIPAL_PASSWORD ]]; then
echo "ACR 'acrpull' service principal password was not found"
exit 1
fi

if [[ -z $ACR_PULL_SERVICE_PRINCIPAL_ID ]]; then
echo "ACR 'acrpull' service principal id was not found"
exit 1
fi