
# Create an event hub

[![eventhubs/create-eventhub/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_create-eventhub_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_create-eventhub_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create a resource group](../../group/create/README.md)
1. [Create a namespace](../create-namespace/README.md)

<!-- workflow.cron(0 1 * * 6) -->
<!-- workflow.include(../../group/create/README.md) -->
<!-- workflow.include(../create-namespace/README.md) -->

## Create the event hub

To create the event hub use the following command line:

````shell
  export EVENTHUBS_EVENTHUB=eventhubs-hub-$RANDOM

  az eventhubs eventhub create \
     --name $EVENTHUBS_EVENTHUB \
     --resource-group $RESOURCE_GROUP \
     --namespace-name $EVENTHUBS_NAMESPACE
````

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az eventhubs eventhub show --name $EVENTHUBS_EVENTHUB --namespace-name $EVENTHUBS_NAMESPACE --resource-group $RESOURCE_GROUP --output tsv --query status)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Active ]]; then
    echo "Azure Event Hubs EventHub - $EVENTHUBS_EVENTHUB - was not provisioned properly"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Event Hubs documentation](https://docs.microsoft.com/azure/event-hubs/README.md)
1. [Create an event hub](https://docs.microsoft.com/en-us/azure/event-hubs/event-hubs-quickstart-cli#create-an-event-hub)

1m
