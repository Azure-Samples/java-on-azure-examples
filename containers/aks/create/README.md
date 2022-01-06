
# Create an Azure Kubernetes Service cluster

[![containers/aks/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containers_aks_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containers_aks_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../../general/group/create/README.md)

## Create an Azure Kubernetes Service cluster

<!-- workflow.include(../../../general/group/create/README.md) -->
<!-- workflow.run()

  if [[ -z $AKS ]]; then
    export AKS=aks-$RANDOM
    az aks create --name $AKS --resource-group $RESOURCE_GROUP --generate-ssh-keys --verbose 
  fi

  -->

To create the cluster use the following command line:

<!-- workflow.skip() -->
```shell
  export AKS=aks-$RANDOM

  az aks create --name $AKS --resource-group $RESOURCE_GROUP --generate-ssh-keys --verbose 
```

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources once you are done running the example.

4m
