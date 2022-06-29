
# Create a SQL container

[![cosmosdb/create-sql-container/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-container_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-container_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Cosmos DB](../create/README.md)
1. [Create a database](../create-sql-database/README.md)

<!-- workflow.cron(0 2 * * 4) -->
<!-- workflow.include(../create-sql-database/README.md) -->

## Create the SQL container

To create the SQL container use the following command lines:

<!-- workflow.skip() -->
````shell
  export COSMOSDB_SQL_CONTAINER=sql-container-$RANDOM

  az cosmosdb sql container create \
    --resource-group $RESOURCE_GROUP \
    --account-name $COSMOSDB_ACCOUNT_NAME \
    --database-name $COSMOSDB_SQL_DATABASE \
    --name $COSMOSDB_SQL_CONTAINER \
    --partition-key-path '/id'
````

<!-- workflow.run()

  if [[ -z $COSMOSDB_SQL_CONTAINER ]]; then
    export COSMOSDB_SQL_CONTAINER=sql-container-$RANDOM
    az cosmosdb sql container create \
      --resource-group $RESOURCE_GROUP \
      --account-name $COSMOSDB_ACCOUNT_NAME \
      --database-name $COSMOSDB_SQL_DATABASE \
      --name $COSMOSDB_SQL_CONTAINER \
      --partition-key-path '/id'
  fi

  -->

## Cleanup

<!-- workflow.directOnly()
  
  export RESULT=$(az cosmosdb sql container show \
    --resource-group $RESOURCE_GROUP \
    --account-name $COSMOSDB_ACCOUNT_NAME \
    --database-name $COSMOSDB_SQL_DATABASE \
    --name $COSMOSDB_SQL_CONTAINER \
    --output tsv --query id)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" == "" ]]; then
    echo "Failed to create CosmosDB SQL container $COSMOSDB_SQL_CONTAINER"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Cosmos DB documentation](https://docs.microsoft.com/azure/cosmos-db/README.md)
1. [Azure CLI - az cosmosdb sql container](https://docs.microsoft.com/cli/azure/cosmosdb/sql/container)

1m
