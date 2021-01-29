
# Send a JMS message to an Azure Service Bus Queue

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Service Bus](../create/)
1. [Create an Azure Service Bus Queue](../create-queue/)

## Send a JMS message to an Azure Service Bus Queue

<!-- workflow.cron(0 5 * * 1) -->
<!-- workflow.include(../create-queue/README.md) -->

First, create the environment variables used to connect to our message queue
using the command line below:


```shell
  export SERVICE_BUS_QUEUE_CONNECTION_STRING=$(az servicebus namespace authorization-rule keys list \
    --resource-group $RESOURCE_GROUP --namespace-name $SERVICE_BUS --name RootManageSharedAccessKey \
    --query primaryConnectionString --output tsv)
```

<!-- workflow.run()

  cd servicebus/send-jms-message

-->

Then build the client:

```shell
  mvn clean package
```

And then send the message:

```shell
  java -jar target/send-jms-message.jar
```

<!-- workflow.run()

  cd ../..

-->

<!-- workflow.directOnly() 

export RESULT=$(az servicebus queue show --resource-group $RESOURCE_GROUP --namespace $SERVICE_BUS --name $SERVICE_BUS_QUEUE --query countDetails.activeMessageCount --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != 1 ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
