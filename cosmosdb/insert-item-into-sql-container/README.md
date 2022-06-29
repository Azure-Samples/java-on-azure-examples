
# Insert an item into a SQL container

[![cosmosdb/insert-item-into-sql-container/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_insert-item-into-sql-container_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_insert-item-into-sql-container_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Cosmos DB](../create/README.md)
1. [Create a SQL database](../create-sql-database/README.md)
1. [Create a SQL container](../create-sql-container/README.md)

<!-- workflow.cron(0 4 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->
<!-- workflow.include(../create/README.md) -->
<!-- workflow.include(../create-sql-database/README.md) -->
<!-- workflow.include(../create-sql-container/README.md) -->

## Insert the item into the SQL container

<!-- workflow.run()

  cd cosmosdb/insert-item-into-sql-container

  -->

First build using the following command line:

```shell
  mvn clean install
```

Second setup the environment variable needed for access:

```shell
  export COSMOSDB_ENDPOINT=$(az cosmosdb show --resource-group $RESOURCE_GROUP \
    --name $COSMOSDB_ACCOUNT_NAME --output tsv --query documentEndpoint)

  export COSMOSDB_MASTER_KEY=$(az cosmosdb keys list --name $COSMOSDB_ACCOUNT_NAME \
    --resource-group $RESOURCE_GROUP --output tsv --query primaryMasterKey)
```

Then execute the following command line:

<!-- workflow.skip() -->
````shell
  java -jar target/insert-item.jar
````

<!-- workflow.run() 

  export RESULT=$(java -jar target/insert-item.jar)
  cd ../..

  -->

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != "Item was added" ]]; then
    echo "Failed to insert item into $COSMOSDB_SQL_CONTAINER"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Cosmos DB documentation](https://docs.microsoft.com/azure/cosmos-db/README.md)

1m
