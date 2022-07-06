# Create a VNet

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/network_create-vnet_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/network_create-vnet_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../.,/group/create/README.md)

## Create a VNet

<!-- workflow.cron(0 0 * * 3) -->
<!-- workflow.include(../../group/create/README.md) -->

First, create the environment variable used for our VNet using the command line
below:

```shell
  export VNET=myvnet
```

Then, create the VNet using the following command line:

```shell
  az network vnet create \
    --name $VNET \
    --resource-group $RESOURCE_GROUP \
    --subnet-name default
```

<!-- workflow.directOnly() 

  export RESULT=$(az network vnet show --resource-group $RESOURCE_GROUP --name $VNET --query provisioningState --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

* [Manage Azure Virtual Networks](https://docs.microsoft.com/cli/azure/network/vnet)

1m
