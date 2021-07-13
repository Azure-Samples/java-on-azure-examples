
# Create an Azure Cosmos DB

[![cosmosdb/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.cron(0 6 * * 1) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Cosmos DB

To create the Azure Cosmos DB use the following command line:

````shell
  export COSMOSDB_NAME=cosmosdb-$RANDOM

  az cosmosdb create \
    --name $COSMOSDB_NAME \
    --resource-group $RESOURCE_GROUP
````

## Cleanup

<!-- workflow.directOnly()
  
  export RESULT=$(az cosmosdb show --name $COSMOSDB_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "$COSMOSDB_NAME was not provisioned properly"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Cosmos DB documentation](https://docs.microsoft.com/azure/cosmos-db/)
1. [Azure CLI - az cosmosdb](https://docs.microsoft.com/cli/azure/cosmosdb/database)
