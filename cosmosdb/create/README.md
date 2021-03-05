
# Create an Azure Cosmos DB

[![cosmosdb/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Cosmos DB

To create the Azure Cosmos DB use the following command line:

````shell
  export COSMOSDB_NAME=cosmosdb-$RANDOM

  az cosmosdb create \
    --name $COSMOSDB_NAME \
    --resource-group $RESOURCE_GROUP
````

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
