
# Upload files to static website

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Storage Account](../storage/create/)
1. [Enale static website hosting](../upload-files-to-static-website/)

## Upload files to static website

To upload a directory containing your static website use following command line:

```shell
  az storage blob upload-batch \
    --source web \
    --destination '$web' \
    --account-name $STORAGE_ACCOUNT_NAME
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
