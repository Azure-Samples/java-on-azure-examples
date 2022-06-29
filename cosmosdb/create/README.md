
# Create an Azure Cosmos DB account

[![cosmosdb/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.cron(0 0 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Cosmos DB account

To create the Azure Cosmos DB account use the following command lines:

<!-- workflow.skip() -->
````shell
  export COSMOSDB_ACCOUNT_NAME=cosmosdb-$RANDOM

  az cosmosdb create \
    --name $COSMOSDB_ACCOUNT_NAME \
    --resource-group $RESOURCE_GROUP
````

<!-- workflow.run()

  if [[ -z $COSMOSDB_ACCOUNT_NAME ]]; then
    export COSMOSDB_ACCOUNT_NAME=cosmosdb-$RANDOM
    az cosmosdb create \
      --name $COSMOSDB_ACCOUNT_NAME \
      --resource-group $RESOURCE_GROUP \
      --locations regionName=eastus failoverPriority=0
  fi

  -->

## Cleanup

<!-- workflow.directOnly()
  
  export RESULT=$(az cosmosdb show --name $COSMOSDB_ACCOUNT_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Failed to create Cosmos DB account $COSMOSDB_ACCOUNT_NAME"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Cosmos DB documentation](https://docs.microsoft.com/azure/cosmos-db/README.md)
1. [Azure CLI - az cosmosdb](https://docs.microsoft.com/cli/azure/cosmosdb)

1m
