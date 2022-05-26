#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
export KEYVAULT_NAME=keyvault-$RANDOM

az keyvault create \
--resource-group $RESOURCE_GROUP \
--name $KEYVAULT_NAME
export KEYVAULT_CERTIFICATE_ALIAS=self-signed
az keyvault certificate create --vault-name $KEYVAULT_NAME \
--name $KEYVAULT_CERTIFICATE_ALIAS \
--policy "$(az keyvault certificate get-default-policy)"

sleep 60
export RESULT=$(az keyvault certificate show --vault-name $KEYVAULT_NAME --name $KEYVAULT_CERTIFICATE_ALIAS --output tsv --query attributes.enabled)
if [[ "$RESULT" != true ]]; then
echo 'Certificate was not provisioned'
az group delete --name $RESOURCE_GROUP --yes || true
exit 1
fi

az group delete --name $RESOURCE_GROUP --yes || true