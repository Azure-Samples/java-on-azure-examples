
# Deploy a Java Function

## Prerequisites

This example assumes you have previously completed the following.

1. [Create an Azure Resource Group](../../group/create/)
1. [Install Azure Functions Core Tools](https://docs.microsoft.com/azure/azure-functions/functions-run-local#install-the-azure-functions-core-tools)

## Set the Java function name

```shell
  export FUNCTIONS_JAVA=functions-java-$RANDOM
```

## Build the example

To build the JAR file use the following Maven command line.

```shell
  mvn -DappName=$FUNCTIONS_JAVA -DresourceGroup=$RESOURCE_GROUP package
```

## Run example locally

To run the example locally use the following Maven command line.

```shell
  mvn -DappName=$FUNCTIONS_JAVA  -DresourceGroup=$RESOURCE_GROUP \
    clean package azure-functions:run
```

You can verify the function works by using your browser and going to 
http://localhost:7071/api/helloworld

You should see `Hello World` in your brower.

## Deploy the Azure Function to Azure

```shell
  mvn -DappName=$FUNCTIONS_JAVA  -DresourceGroup=$RESOURCE_GROUP \
    clean package azure-functions:deploy
```

To verify the function works open your browser to the URL echoed by the 
following command line:

```shell
  echo `az functionapp show \
    --resource-group $RESOURCE_GROUP \
    --name $FUNCTIONS_JAVA \
    --query hostNames \
    --output tsv`/api/helloworld
```

You should see `Hello World` in your browser.

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Azure Functions documentation](https://docs.microsoft.com/en-us/azure/azure-functions/)
* [Manage function apps](https://docs.microsoft.com/cli/azure/functionapp)

5m
