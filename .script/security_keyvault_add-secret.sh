#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION

if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
export KEYVAULT_NAME=keyvault-$RANDOM

az keyvault create \
--resource-group $RESOURCE_GROUP \
--name $KEYVAULT_NAME
az keyvault secret set \
--name mySecret \
--value mySecretValue \
--vault-name $KEYVAULT_NAME

export RESULT=$(az keyvault secret show --name mySecret --vault $KEYVAULT_NAME --query value --output tsv)
if [[ "$RESULT" != "mySecretValue" ]]; then
echo 'Secret was not properly set'
az group delete --name $RESOURCE_GROUP --yes || true
exit 1
fi

az group delete --name $RESOURCE_GROUP --yes || true