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

cd containers/acr/quarkus

mvn package
export ACR_QUARKUS_IMAGE=quarkus:latest

az acr build --registry $ACR_NAME --resource-group $RESOURCE_GROUP --image $ACR_QUARKUS_IMAGE .

cd ../../..


export RESULT=$(az acr repository show --name $ACR_NAME --image $ACR_QUARKUS_IMAGE)
az group delete --name $RESOURCE_GROUP --yes || true

if [[ -z $RESULT ]]; then
echo "Unable to find $ACR_QUARKUS_IMAGE image"
exit 1
fi