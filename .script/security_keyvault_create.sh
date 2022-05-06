#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
fi

az group create --name $RESOURCE_GROUP --location $REGION
export KEYVAULT_NAME=keyvault-$RANDOM

az keyvault create \
--resource-group $RESOURCE_GROUP \
--name $KEYVAULT_NAME

export RESULT=$(az keyvault show --resource-group $RESOURCE_GROUP --name $KEYVAULT_NAME --output tsv --query properties.provisioningState)
if [[ "$RESULT" != Succeeded ]]; then
echo 'Key vault was not provisioned'
az group delete --name $RESOURCE_GROUP --yes || true
exit 1
fi

az group delete --name $RESOURCE_GROUP --yes || true