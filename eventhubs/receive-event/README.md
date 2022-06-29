
# Receive an event

[![eventhubs/receive-event/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_receive-event_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_receive-event_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create a resource group](../../group/create/README.md)
1. [Create a namespace](../create-namespace/README.md)
1. [Create an event hub](../create-eventhub/README.md)
1. [Send an event](../send-event/README.md)

<!-- workflow.cron(0 3 * * 6) -->
<!-- workflow.include(../../group/create/README.md) -->
<!-- workflow.include(../create-namespace/README.md) -->
<!-- workflow.include(../create-eventhub/README.md) -->
<!-- workflow.include(../send-event/README.md) -->

## Receive an event

Build the JAR file using the Maven command line below:

<!-- workflow.run() 

  cd eventhubs/receive-event

  -->


```shell
  mvn clean install
```

Execute the following command line to receive an event from the event hub:

<!-- workflow.skip() -->
```shell
  java -jar target/receive-event.jar
```

<!-- workflow.run()

  export RESULT=$(java -jar target/receive-event.jar)
  cd ../..

  -->

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != 'Received: this is an event' ]]; then
    echo "Error when receiving event from EventHub"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Event Hubs documentation](https://docs.microsoft.com/azure/event-hubs/README.md)
1. [Use Java to send events to or receive events from Azure Event Hubs (azure-messaging-eventhubs)](https://docs.microsoft.com/azure/event-hubs/event-hubs-java-get-started-send)
