
# Create an event hub

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create a resource group](../../group/create/README.md)
1. [Create a namespace](../create-namespace/README.md)

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

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
