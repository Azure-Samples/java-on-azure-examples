
# Create an Azure Storage Account

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

<!-- workflow.cron(0 1 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->

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

<!-- workflow.directOnly() 
export RESULT=$(az storage account show --resource-group $RESOURCE_GROUP --name $STORAGE_ACCOUNT_NAME --query provisioningState --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
  exit 1
fi
  -->

Do NOT forget to remove the resources once you are done running the example.

1m
