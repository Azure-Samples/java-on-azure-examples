
# Push a WildFly Docker image to Azure Container Registry

![acr/wildfly/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/wildfly/README.md/badge.svg)

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../create/)

<!-- workflow.cron(0 10 * * 2) -->
<!-- workflow.include(../create/README.md) -->

## Build the WAR file

To build the WAR file use the following command line:

<!-- workflow.run()

cd acr/wildfly

  -->

```shell
  mvn package
```

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command line below:

```shell
  export ACR_WILDFLY_IMAGE=wildfly:latest

  az acr build --registry $ACR --image $ACR_WILDFLY_IMAGE .
```

<!-- workflow.run()

cd ../..

  -->

<!-- workflow.directOnly()

export RESULT=$(az acr repository show --name $ACR --image $ACR_WILDFLY_IMAGE)
az group delete --name $RESOURCE_GROUP --yes || true

if [[ -z $RESULT ]]; then
  echo "Unable to find $ACR_WILDFLY_IMAGE image"
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m
