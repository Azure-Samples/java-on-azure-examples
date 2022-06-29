
# Deploy a Cosmos DB output Function

[![functionapp/cosmosdb-output/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functionapp_cosmosdb-output_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functionapp_cosmosdb-output_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Install Azure Functions Core Tools](../install-tools/README.md)
1. [Create an Azure Cosmos DB](../../cosmosdb/create/README.md)

<!-- workflow.cron(0 1 * * 2) -->
<!-- workflow.include(../install-tools/README.md) -->
<!-- workflow.include(../../cosmosdb/create/README.md) -->

<!-- workflow.run() 

  cd functionapp/cosmosdb-output

  -->

## Set the Java function name environment variable

```shell
  export FUNCTIONS_COSMOSDB=functions-cosmosdb-$RANDOM
```

## Set the Cosmos DB connection string environment variable

```shell
  export FUNCTIONS_COSMOSDB_CONNECTION_STRING="$(az cosmosdb keys list --resource-group $RESOURCE_GROUP --name $COSMOSDB_ACCOUNT_NAME --type connection-strings --query connectionStrings[0].connectionString --output tsv)"
```

## Setup the local environment

```shell
  mvn -P local validate
```

## Build the example

To build the JAR file use the following Maven command line.

```shell
  mvn -DresourceGroup=$RESOURCE_GROUP -DappName=$FUNCTIONS_COSMOSDB  package
```

## Run the example locally

To run the example locally use the following Maven command line.

<!-- workflow.skip() -->
```shell
  mvn -DappName=$FUNCTIONS_COSMOSDB  -DresourceGroup=$RESOURCE_GROUP \
    clean package azure-functions:run
```

You can verify the function works by using your browser and going to 
http://localhost:7071/api/cosmosDBOutput

You should see `We stored an item in Cosmos DB` in your brower.

## Deploy the example to Azure

```shell
  mvn -DappName=$FUNCTIONS_COSMOSDB  -DresourceGroup=$RESOURCE_GROUP \
    -DcosmosDBConnectionString="$FUNCTIONS_COSMOSDB_CONNECTION_STRING" \
    clean package azure-functions:deploy
```

To verify the function works open your browser to the URL echoed by the 
following command line:

<!-- workflow.skip() -->
```shell
  echo `az functionapp show \
    --resource-group $RESOURCE_GROUP \
    --name $FUNCTIONS_COSMOSDB \
    --query hostNames \
    --output tsv`/api/cosmosDBOutput
```

<!-- workflow.run() 

  cd ../..

  -->

<!-- workflow.directOnly() 

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

You should see `We stored an item in Cosmos DB` in your browser.

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Azure Functions documentation](https://docs.microsoft.com/en-us/azure/azure-functions/README.md)
* [Manage function apps](https://docs.microsoft.com/cli/azure/functionapp)

5m
