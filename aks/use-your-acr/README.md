
# Update your cluster to use your Azure Container Registry

[![aks/use-your-acr/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_use-your-acr_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_use-your-acr_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Kubernetes Service cluster](../create/)
1. [Create an Azure Container Registry](../../acr/create/)

## Update your cluster to use your Azure Container Registry

<!-- workflow.include(../create/README.md) -->
<!-- workflow.include(../../acr/create/README.md) -->

To update your cluster to make it so it can access your Azure Container
Registry you need to use the following command line.

```shell
  az aks update --name $AKS --resource-group $RESOURCE_GROUP --attach-acr $ACR_NAME
```

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
