#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
export STORAGE_ACCOUNT_NAME=storage$RANDOM

az storage account create \
--name $STORAGE_ACCOUNT_NAME \
--resource-group $RESOURCE_GROUP \
--sku Standard_LRS \
--kind StorageV2

export STORAGE_ACCOUNT_CONNECTION_STRING=$(az storage account show-connection-string --resource-group $RESOURCE_GROUP --name $STORAGE_ACCOUNT_NAME --output tsv)
az storage blob service-properties update \
--account-name $STORAGE_ACCOUNT_NAME \
--connection-string $STORAGE_ACCOUNT_CONNECTION_STRING \
--static-website \
--404-document 404.html \
--index-document index.html

az storage account show \
--name $STORAGE_ACCOUNT_NAME \
--resource-group $RESOURCE_GROUP \
--query primaryEndpoints.web \
--output tsv

cd storage/storage/upload-files-to-static-website

az storage blob upload-batch \
--source web \
--destination '$web' \
--account-name $STORAGE_ACCOUNT_NAME \
--connection-string $STORAGE_ACCOUNT_CONNECTION_STRING

sleep 60
cd ../../..


export URL=$(az storage account show --name $STORAGE_ACCOUNT_NAME --query primaryEndpoints.web --output tsv)index.html
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"Azure Storage"* ]]; then
echo "Response did not contain 'This is served from Azure Storage'"
exit 1
fi