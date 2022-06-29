
# Build and push a Piranha Micro application to Azure Container Registry

[![containers/acr/piranha/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containers_acr_piranha_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containers_acr_piranha_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../create/README.md)

<!-- workflow.cron(0 13 * * 0) -->
<!-- workflow.include(../create/README.md) -->

## Build the example locally

<!-- workflow.run()

  cd acr/piranha

  -->

To build the WAR file use the following Maven command line:

```shell
  mvn package
```

## Build and push the container image to your Azure Container Registry

To build and push the container image to your ACR use the command lines below:

```shell
  export ACR_PIRANHA_IMAGE=piranha:latest

  az acr build --registry $ACR_NAME --resource-group $RESOURCE_GROUP --image $ACR_PIRANHA_IMAGE .
```

<!-- workflow.run()

  cd ../..

  -->

<!-- workflow.directOnly()

  export RESULT=$(az acr repository show --name $ACR_NAME --image $ACR_PIRANHA_IMAGE)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ -z $RESULT ]]; then
    echo "Unable to find $ACR_PIRANHA_IMAGE image"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources you created once you are done running the
example.

4m
