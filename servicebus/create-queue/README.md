
# Create an Azure Service Bus Queue

[![servicebus/create-queue/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_create-queue_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_create-queue_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Service Bus](../create/README.md)

## Create an Azure Service Bus Queue

<!-- workflow.cron(0 1 * * 5) -->
<!-- workflow.include(../create/README.md) -->

First, create the environment variable used for our message queue
using the command line below:

<!-- workflow.skip() -->
```shell
  export SERVICE_BUS_QUEUE=service-bus-queue
```

<!-- workflow.run() 
if [[ -z $SERVICE_BUS_QUEUE ]]; then
  export SERVICE_BUS_QUEUE=service-bus-queue-$RANDOM
fi
-->

Then, create the Azure Service Bus using the following command line:

```shell
  az servicebus queue create \
    --resource-group $RESOURCE_GROUP \
    --namespace-name $SERVICE_BUS \
    --name $SERVICE_BUS_QUEUE
```

<!-- workflow.directOnly() 

  export RESULT=$(az servicebus queue show --resource-group $RESOURCE_GROUP --namespace $SERVICE_BUS --name $SERVICE_BUS_QUEUE --query status --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Active ]]; then
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
