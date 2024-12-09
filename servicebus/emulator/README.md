
# Send and receive a message to a local Azure Service Bus Emulator

## Prerequisites

This example assumes you have Docker installed as it uses the Azure Service Bus Emulator Docker image.

## Start the Azure Service Bus Emulator

Make sure Docker Engine is operational in the background. Then, start the Azure Service Bus Emulator using the following command:

```shell
docker compose -f src/main/docker/docker-compose.yaml up -d
```

## Send and receive messages to an Azure Service Bus Emulator

First, create the environment variables used to connect to our Azure Service Bus Emulator
using the command line below:


```shell
  export SERVICE_BUS_QUEUE_CONNECTION_STRING=Endpoint=sb://127.0.0.1;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=SAS_KEY_VALUE;UseDevelopmentEmulator=true;
  export SERVICE_BUS_QUEUE=queue.1
```

Then compile the code:

```shell
  mvn clean compile
```

Listen to the incoming messages with the following command:

```shell
  mvn exec:java -Preceive
```

And then send messages:

```shell
  mvn exec:java -Psend
```

## Cleanup

```shell
docker compose -f src/main/docker/docker-compose.yaml down
```

## References

* [Overview of the Azure Service Bus emulator](https://learn.microsoft.com/en-us/azure/service-bus-messaging/overview-emulator)
* [Test locally by using the Azure Service Bus emulator](https://learn.microsoft.com/en-us/azure/service-bus-messaging/test-locally-with-service-bus-emulator?tabs=docker-linux-container)
* [Azure Service Bus emulator config file](https://github.com/Azure/azure-service-bus-emulator-installer/blob/main/ServiceBus-Emulator/Config/Config.json)
* [Simple Azure Service Bus Emulator – Finally Here!](https://devopsifyme.com/simple-azure-service-bus-emulator-finally-here)
* [Azure SQL Edge Docker image](https://hub.docker.com/r/microsoft/azure-sql-edge)
* [Emulator connection string support](https://github.com/Azure/azure-sdk-for-java/issues/38735)
