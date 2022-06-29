
# Push a Glassfish Docker image

[![acr/glassfish/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_glassfish_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_glassfish_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../create/README.md)

<!-- workflow.cron(0 3 * * 0) -->
<!-- workflow.include(../create/README.md) -->

## Build the WAR file

<!-- workflow.run()

  cd acr/glassfish

  -->

To build the WAR file use the following command line:

```shell
  mvn package
```

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command line below:

```shell
  export ACR_GLASSFISH_IMAGE=glassfish:latest

  az acr build --resource-group $RESOURCE_GROUP --registry $ACR_NAME --image $ACR_GLASSFISH_IMAGE .
```

You can then use the following command to display the content on the ACR:

```shell
  az acr repository list --name $ACR_NAME --output table
```

<!-- workflow.run()

  cd ../..

  -->

<!-- workflow.directOnly()

  export RESULT=$(az acr repository show --name $ACR_NAME --image $ACR_GLASSFISH_IMAGE)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ -z $RESULT ]]; then
    echo "Unable to find $ACR_GLASSFISH_IMAGE image"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m
