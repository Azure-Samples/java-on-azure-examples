
# Create an Azure Kubernetes Service cluster

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)

## Create an Azure Kubernetes Service cluster

<!-- workflow.include(../../group/create/README.md) -->

To create the cluster use the following command line:

```shell
  export AKS=aks-$RANDOM

  az aks create --name $AKS --resource-group $RESOURCE_GROUP --verbose 
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

4m
