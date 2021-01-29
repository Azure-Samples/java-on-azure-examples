
# Create an Azure Storage Account

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

## Create the Azure Storage Account

To create the Azure Storage Account use the following command line:

```shell
  export STORAGE_ACCOUNT_NAME=storage$RANDOM

  az storage account create \
    --name $STORAGE_ACCOUNT_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku Standard_LRS \
    --kind StorageV2
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
