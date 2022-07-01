
# Create an Azure Service Bus

[![servicebus/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

## Create an Azure Service Bus

<!-- workflow.cron(0 0 * * 5) -->
<!-- workflow.include(../../group/create/README.md) -->

First, create the environment variable used for our Service Bus
using the command line below:

```shell
  export SERVICE_BUS=service-bus-$RANDOM
```

Then, create the Azure Service Bus using the following command line:

```shell
  az servicebus namespace create \
    --resource-group $RESOURCE_GROUP \
    --name $SERVICE_BUS \
    --sku Premium \
    --location $REGION
```

<!-- workflow.directOnly() 

  export RESULT=$(az servicebus namespace show --resource-group $RESOURCE_GROUP --name $SERVICE_BUS --query provisioningState --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
