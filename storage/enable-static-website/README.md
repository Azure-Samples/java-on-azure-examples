
# Enable static website hosting

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Storage Account](../account/create/)

## Enable static website hosting

To enable static website hosting execute the following command line:

```shell
  az storage blob service-properties update \
    --account-name $STORAGE_ACCOUNT_NAME \
    --static-website \
    --404-document 404.html \
    --index-document index.html

  az storage account show \
    --name $STORAGE_ACCOUNT_NAME \
    --query primaryEndpoints.web \
    --output tsv
```

You can browse to the URL shown and it will show you a 404 error page as the
content has not be uploaded yet.

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
