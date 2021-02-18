
# Push a Quarkus Docker image to Azure Container Registry

![acr/quarkus/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/quarkus/README.md/badge.svg)

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../create/)

<!-- workflow.cron(0 8 * * 2) -->
<!-- workflow.include(../create/README.md) -->

## Build the example

<!-- workflow.run()

cd acr/quarkus

  -->

To build the JAR file use the following Maven command line:

```shell
  mvn package
```

## Run the example locally

To run the example locally use the following Maven command line:

<!-- workflow.skip() -->
```shell
  mvn quarkus:dev
```

You can see the application in action at http://localhost:8080/hello

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command lines below:

```shell
  export ACR_QUARKUS_IMAGE=quarkus:latest

  az acr build --registry $ACR --image $ACR_QUARKUS_IMAGE .
```

<!-- workflow.run()

cd ../..

  -->

<!-- workflow.directOnly()

export RESULT=$(az acr repository show --name $ACR --image $ACR_QUARKUS_IMAGE)
az group delete --name $RESOURCE_GROUP --yes || true

if [[ -z $RESULT ]]; then
  echo "Unable to find $ACR_QUARKUS_IMAGE image"
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources you created once you are done running the
example.

4m
