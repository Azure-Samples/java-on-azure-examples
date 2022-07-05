
# Enable static website hosting

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_enable-static-website_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_enable-static-website_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Storage Account](../create/README.md)

<!-- workflow.cron(0 2 * * 1) -->
<!-- workflow.include(../create/README.md) -->

## Enable static website hosting

To enable static website hosting execute the following command lines:

```shell
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
```

You can browse to the URL shown and it will show you a 404 error page as the
content has not be uploaded yet.

## Cleanup

<!-- workflow.directOnly() 

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
