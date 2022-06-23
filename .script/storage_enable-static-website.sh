#!/bin/bash
cd ..

# WARN File could not be found: storage/storage/create/README.md
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

az group delete --name $RESOURCE_GROUP --yes || true