
# Upload files to static website

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_upload-files-to-static-website_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_upload-files-to-static-website_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Storage Account](../create/README.md)
1. [Enale static website hosting](../enable-static-website/README.md)

<!-- workflow.cron(0 3 * * 1) -->
<!-- workflow.include(../enable-static-website/README.md) -->

## Upload files to static website

<!-- workflow.run() 

cd storage/upload-files-to-static-website

  -->

To upload a directory containing your static website use the following command
line:

```shell
  az storage blob upload-batch \
    --source web \
    --destination '$web' \
    --account-name $STORAGE_ACCOUNT_NAME \
    --connection-string $STORAGE_ACCOUNT_CONNECTION_STRING
```

<!-- workflow.run() 

sleep 60
cd ../..

  -->

## Cleanup

<!-- workflow.directOnly() 

  export URL=$(az storage account show --name $STORAGE_ACCOUNT_NAME --query primaryEndpoints.web --output tsv)index.html
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Azure Storage"* ]]; then
    echo "Response did not contain 'This is served from Azure Storage'"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
