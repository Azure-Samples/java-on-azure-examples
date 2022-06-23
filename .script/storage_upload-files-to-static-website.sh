#!/bin/bash
cd ..

# WARN File could not be found: storage/storage/enable-static-website/README.md

cd storage/upload-files-to-static-website

az storage blob upload-batch \
--source web \
--destination '$web' \
--account-name $STORAGE_ACCOUNT_NAME \
--connection-string $STORAGE_ACCOUNT_CONNECTION_STRING

sleep 60
cd ../..


export URL=$(az storage account show --name $STORAGE_ACCOUNT_NAME --query primaryEndpoints.web --output tsv)index.html
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"Azure Storage"* ]]; then
echo "Response did not contain 'This is served from Azure Storage'"
exit 1
fi