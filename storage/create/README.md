
# Create an Azure Storage Account

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.cron(0 1 * * 1) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Storage Account

To create the Azure Storage Account use the following command lines:

```shell
  export STORAGE_ACCOUNT_NAME=storage$RANDOM

  az storage account create \
    --name $STORAGE_ACCOUNT_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku Standard_LRS \
    --kind StorageV2

 export STORAGE_ACCOUNT_CONNECTION_STRING=$(az storage account show-connection-string --resource-group $RESOURCE_GROUP --name $STORAGE_ACCOUNT_NAME --output tsv)
```

## Cleanup

<!-- workflow.directOnly() 

  export RESULT=$(az storage account show --resource-group $RESOURCE_GROUP --name $STORAGE_ACCOUNT_NAME --query provisioningState --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi  

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
