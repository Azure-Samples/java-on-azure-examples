#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
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

cd containers/acr/wildfly

mvn package
export ACR_WILDFLY_IMAGE=wildfly:latest

az acr build --registry $ACR_NAME --image $ACR_WILDFLY_IMAGE .

cd ../../..


export RESULT=$(az acr repository show --name $ACR_NAME --image $ACR_WILDFLY_IMAGE)
az group delete --name $RESOURCE_GROUP --yes || true

if [[ -z $RESULT ]]; then
echo "Unable to find $ACR_WILDFLY_IMAGE image"
exit 1
fi