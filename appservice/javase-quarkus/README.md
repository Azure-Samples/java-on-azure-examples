
# Deploy a managed JavaSE Quarkus application

[![appservice/javase-quarkus/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_javase-quarkus_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_javase-quarkus_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)

<!-- workflow.cron(0 15 * * 5) -->
<!-- workflow.include(../create-plan/README.md) -->

## Build the example

To build the JAR file use the following Maven command line.

<!-- workflow.run() 

  cd appservice/javase-quarkus

  -->

```shell
  mvn package
```

## Run example locally

To run the example locally use the following Maven command line.

<!-- workflow.skip() -->
```shell
  mvn quarkus:dev
```

You can see the application in action at http://localhost:8080/hello

## Deploy the managed JavaSE Quarkus application

To deploy the application use the following command lines:

````shell
  export APPSERVICE_JAVASE_QUARKUS=appservice-javase-quarkus-$RANDOM

  mvn azure-webapp:deploy \
    -DappName=$APPSERVICE_JAVASE_QUARKUS \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
````

<!-- workflow.run()

  cd ../..

  -->

Once the command completes you will be able to see the example by using your web
browser and going to the ```xxxxx.azurewebsites.net``` address the command echoes.

<!-- workflow.directOnly() 

  sleep 60
  export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_JAVASE_QUARKUS --output tsv --query state)
  if [[ "$RESULT" != Running ]]; then
    echo 'Web application is NOT running'
    az group delete --name $RESOURCE_GROUP --yes || true
    exit 1
  fi
  sleep 60
  export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_JAVASE_QUARKUS --output tsv --query defaultHostName)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello"* ]]; then
    echo "Response did not contain 'Hello'"
    exit 1
  fi

  -->

### Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                     | description                      |
|--------------------------|----------------------------------|
| `example.appName`        | the application name             |
| `example.appServicePlan` | the App Service plan to use      |
| `example.resourceGroup`  | the Azure Resource Group name    |

## Cleanup

Do NOT forget to remove the App Service and its associated resources once you are
done running the example.
