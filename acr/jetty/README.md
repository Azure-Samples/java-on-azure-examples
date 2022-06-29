
# Push a Jetty Docker image to Azure Container Registry

[![acr/jetty/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_jetty_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_jetty_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../create/README.md)

<!-- workflow.cron(0 5 * * 0) -->
<!-- workflow.include(../create/README.md) -->

## Build the WAR file

<!-- workflow.run()

  cd acr/jetty

  -->

To build the WAR file use the following command line:

```shell
  mvn package
```

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command lines below:

```shell
  export ACR_JETTY_IMAGE=jetty:latest

  az acr build --resource-group $RESOURCE_GROUP --registry $ACR_NAME --image $ACR_JETTY_IMAGE .
```

<!-- workflow.run()

  cd ../..

  -->

<!-- workflow.directOnly()

  export RESULT=$(az acr repository show --name $ACR_NAME --image $ACR_JETTY_IMAGE)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ -z $RESULT ]]; then
    echo "Unable to find $ACR_JETTY_IMAGE image"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
