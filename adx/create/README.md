
# Create an Azure Data Explorer cluster

![adx/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/adx/create/README.md/badge.svg)

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)

## Create an Azure Data Explorer cluster

<!-- workflow.include(../../group/create/README.md) -->

Install the CLI extension using the following command line:

```shell
  az extension add -n kusto
```

Setup the environment variable for the Azure Data Explorer cluster using the
command line below:

<!-- workflow.skip() -->
```shell
  export ADX_NAME=adxcluster$RANDOM
```

<!-- workflow.run()

  if [[ -z $ADX_NAME ]]; then
    export ADX_NAME=adxcluster$RANDOM
  fi

  -->

To create the cluster use the following command line:

```shell
  az kusto cluster create \
    --cluster-name $ADX_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku name="Standard_D13_v2" tier="Standard" \
    --location $REGION \
    --type SystemAssigned
```

<!-- workflow.directOnly()

  export RESULT=$(az kusto cluster show --name $ADX_NAME \
    --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Failed to create Azure Data Explorer cluster $ADX_NAME"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

10m