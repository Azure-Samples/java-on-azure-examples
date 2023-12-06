
# Create an Azure Kubernetes Service cluster

[![aks/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_create_README_md.yml)

## Prerequisites

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus3
  fi

  -->
<!-- workflow.cron(0 22 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

## Create an Azure Kubernetes Service cluster

<!-- workflow.run()

  if [[ -z $AKS ]]; then
    export AKS=aks-$RANDOM
    echo ---------------------------------------------------------------------
    echo  Creating AKS cluster - $AKS
    echo ---------------------------------------------------------------------
    az aks create --name $AKS --resource-group $RESOURCE_GROUP --generate-ssh-keys --verbose
    sleep 120 
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

  export RESULT=$(az aks show --name $AKS --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Create a Kubeconfig file using admin access](../create-kube-config/README.md)

## Reference documentation

* [Commands to manage Azure Kubernetes Services](https://docs.microsoft.com/cli/azure/aks)
* [Azure Kubernetes Service Documentation](https://docs.microsoft.com/azure/aks/)

5m
