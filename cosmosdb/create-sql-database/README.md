
# Create a SQL database

[![cosmosdb/create-sql-database/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-database_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-database_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Cosmos DB](../create/README.md)

<!-- workflow.cron(0 6 * * 3) -->
<!-- workflow.include(../../group/create/README.md) -->
<!-- workflow.include(../create/README.md) -->

## Create the SQL database

To create the SQL database use the following command lines:

````shell
  export COSMOSDB_SQL_DATABASE=sql-database-$RANDOM

  az cosmosdb sql database create \
    --resource-group $RESOURCE_GROUP \
    --account-name $COSMOSDB_NAME \
    --name $COSMOSDB_SQL_DATABASE
````

## Cleanup

<!-- workflow.directOnly()
  
  export RESULT=$(az cosmosdb sql database show \
    --resource-group $RESOURCE_GROUP \
    --account-name $COSMOSDB_NAME \
    --name $COSMOSDB_SQL_DATABASE \
    --output tsv --query id)

  az group delete --name $RESOURCE_GROUP --yes || true

  if [[ "$RESULT" == "" ]]; then
    echo "$COSMOSDB_SQL_DATABASE was not provisioned properly"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Cosmos DB documentation](https://docs.microsoft.com/azure/cosmos-db/)
1. [Azure CLI - az cosmosdb sql database](https://docs.microsoft.com/cli/azure/cosmosdb/sql/database)

1m
