
# Deploy a Java Function

[![functions/java/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functions_java_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functions_java_README_md.yml)

## Prerequisites

<!-- workflow.cron(0 3 * * 2) -->
<!-- workflow.include(../../../general/group/create/README.md) -->
<!-- workflow.include(../install-tools/README.md) -->

This example assumes you have previously completed the following.

1. [Create an Azure Resource Group](../../../general/group/create/README.md)
1. [Install Azure Functions Core Tools](https://docs.microsoft.com/azure/azure-functions/functions-run-local#install-the-azure-functions-core-tools)

<!-- workflow.run() 

cd compute/functions/java
mkdir .mvn
echo "-ntp" > .mvn/maven.config

  -->

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

<!-- workflow.skip() -->
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

<!-- workflow.run()

cd ../../..

 -->

## Cleanup

<!-- workflow.directOnly() 

  az group delete --name $RESOURCE_GROUP --yes || true
  
  -->

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Azure Functions documentation](https://docs.microsoft.com/en-us/azure/azure-functions/README.md)
* [Manage function apps](https://docs.microsoft.com/cli/azure/functionapp)

5m
