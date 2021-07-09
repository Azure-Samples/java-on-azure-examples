
# Create an Azure Event Hubs namespace

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Event Hubs namespace

To create the namespace use the following command line:

````shell
  export EVENTHUBS_NAMESPACE=eventhubs-$RANDOM

  az eventhubs namespace create \
     --name $EVENTHUBS_NAMESPACE \
     --resource-group $RESOURCE_GROUP \
     --location $REGION
````

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources once you are done running the example.
