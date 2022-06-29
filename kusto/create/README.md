
# Create an Azure Data Explorer cluster

[![kusto/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/kusto_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/kusto_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

## Create an Azure Data Explorer cluster

<!-- workflow.cron(0 0 * * 0) -->
<!-- workflow.include(../../group/create/README.md) -->

Install the CLI extension using the following command line:

```shell
  az extension add -n kusto
```

Setup the environment variable for the Azure Data Explorer cluster using the
command line below:

<!-- workflow.skip() -->
```shell
  export ADX_CLUSTER_NAME=adxcluster$RANDOM
```

To create the cluster use the following command line:

<!-- workflow.skip() -->
```shell
  az kusto cluster create \
    --cluster-name $ADX_CLUSTER_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku name="Standard_D13_v2" tier="Standard" \
    --location $REGION \
    --type SystemAssigned
```

<!-- workflow.run()

  if [[ -z $ADX_CLUSTER_NAME ]]; then
    export ADX_CLUSTER_NAME=adxcluster$RANDOM
    az kusto cluster create \
      --cluster-name $ADX_CLUSTER_NAME \
      --resource-group $RESOURCE_GROUP \
      --sku name="Standard_D13_v2" tier="Standard" \
      --location $REGION \
      --type SystemAssigned
  fi

  -->

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az kusto cluster show --name $ADX_CLUSTER_NAME \
    --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Failed to create Azure Data Explorer cluster $ADX_CLUSTER_NAME"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Data Explorer documentation](https://docs.microsoft.com/azure/data-explorer/README.md)
1. [Azure CLI - az kusto](https://docs.microsoft.com/cli/azure/kusto)

10m
