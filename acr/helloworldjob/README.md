
# Build and push a Hello World Job application to Azure Container Registry

[![acr/helloworldjob/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_helloworldjob_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_helloworldjob_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../create/README.md)

<!-- 

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 7 * * 0) -->
<!-- workflow.javaVersion(17) -->
<!-- workflow.include(../create/README.md) -->

## Build the example

<!-- workflow.run()

  cd acr/helloworldjob

  -->

To build the JAR file use the following Maven command line:

```shell
  mvn -ntp package
```

## Build and push the container image to your Azure Container Registry

To build and push the container image to your ACR use the command lines below:

```shell
  export ACR_HELLOWORLDJOB_IMAGE=helloworldjob:latest

  az acr build --registry $ACR_NAME --resource-group $RESOURCE_GROUP --image $ACR_HELLOWORLDJOB_IMAGE .
```

<!-- workflow.run()

  cd ../..

  -->

<!-- workflow.directOnly()

  export RESULT=$(az acr repository show --name $ACR_NAME --image $ACR_HELLOWORLDJOB_IMAGE)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ -z $RESULT ]]; then
    echo "Unable to find " $ACR_HELLOWORLDJOB_IMAGE " image"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources you created once you are done running the
example.

4m
