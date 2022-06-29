
# Send an event

[![eventhubs/send-event/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_send-event_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_send-event_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create a resource group](../../group/create/README.md)
1. [Create a namespace](../create-namespace/README.md)
1. [Create an event hub](../create-eventhub/README.md)

<!-- workflow.cron(0 2 * * 6) -->
<!-- workflow.include(../../group/create/README.md) -->
<!-- workflow.include(../create-namespace/README.md) -->
<!-- workflow.include(../create-eventhub/README.md) -->

## Send an event

Execute the command line below to setup the connection string we will use to
connect to the event hub:

````shell
  export EVENTHUBS_EVENTHUB_CONNECTION_STRING=$(az eventhubs namespace authorization-rule keys list \
    --resource-group $RESOURCE_GROUP \
    --namespace-name $EVENTHUBS_NAMESPACE \
    --name RootManageSharedAccessKey \
    --query primaryConnectionString \
    --output tsv)
````

<!-- workflow.run() 

  cd eventhubs/send-event

  -->

Build the JAR file using the Maven command line below:

```shell
  mvn clean install
```

Execute the following command line to send the event to the event hub:

<!-- workflow.skip() -->
```shell
  java -jar target/send-event.jar
```

<!-- workflow.run()

  export RESULT=$(java -jar target/send-event.jar)
  cd ../..

  -->


## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != 'Event was sent successfully' ]]; then
    echo "Error when sending event to EventHub"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Event Hubs documentation](https://docs.microsoft.com/azure/event-hubs/README.md)
1. [Get an Event Hubs connection string](https://docs.microsoft.com/azure/event-hubs/event-hubs-get-connection-string)
1. [Use Java to send events to or receive events from Azure Event Hubs (azure-messaging-eventhubs)](https://docs.microsoft.com/azure/event-hubs/event-hubs-java-get-started-send)
