
# Push a Payara Docker image to Azure Container Registry

[![acr/payara/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_payara_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_payara_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../create/README.md)

<!-- workflow.cron(0 6 * * 0) -->
<!-- workflow.include(../create/README.md) -->

## Build the WAR file

<!-- workflow.run()

  cd acr/payara

  -->

To build the WAR file use the following command line:

```shell
  mvn package
```

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command line below:

```shell
  export ACR_PAYARA_IMAGE=payara:latest

  az acr build --registry $ACR_NAME --image $ACR_PAYARA_IMAGE .
```

<!-- workflow.run()

  cd ../..

  -->

<!-- workflow.directOnly()

  export RESULT=$(az acr repository show --name $ACR_NAME --image $ACR_PAYARA_IMAGE)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ -z $RESULT ]]; then
    echo "Unable to find $ACR_PAYARA_IMAGE image"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m
