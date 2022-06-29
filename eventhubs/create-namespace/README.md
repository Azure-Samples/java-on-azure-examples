
# Create a namespace

[![eventhubs/create-namespace/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_create-namespace_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_create-namespace_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create a resource group](../../group/create/README.md)

<!-- workflow.cron(0 0 * * 6) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the namespace

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

  export RESULT=$(az eventhubs namespace show --name $EVENTHUBS_NAMESPACE --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Event Hubs namespace - $EVENTHUBS_NAMESPACE - was not provisioned properly"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Event Hubs documentation](https://docs.microsoft.com/azure/event-hubs/README.md)
1. [Create an Event Hubs namespace](https://docs.microsoft.com/azure/event-hubs/event-hubs-quickstart-cli#create-an-event-hubs-namespace)

1m
