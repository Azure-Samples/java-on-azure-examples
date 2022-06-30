
# Lettuce command line client

[![redis/lettuce/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/redis_lettuce_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/redis_lettuce_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Cache for Redis](../create/README.md)

<!-- workflow.cron(0 1 * * 0) -->
<!-- workflow.include(../create/README.md) -->
<!-- workflow.run()

  cd redis/lettuce

  -->

## Build the command line client

To build the Lettuce command line client use the command line below:

```shell
  mvn clean package
```

## Get the host and password for the Azure Cache for Redis

To get the host and password execute the command lines below:

```shell
  export REDIS_HOST=$(az redis show --resource-group $RESOURCE_GROUP --name $REDIS_NAME --query hostName --output tsv)
  export REDIS_PASSWORD=$(az redis list-keys --resource-group $RESOURCE_GROUP --name $REDIS_NAME --query primaryKey --output tsv)
```

## Set a value using the command line client

Next we are going to set a value using the command line:

```shell
  java -jar target/redis-lettuce.jar --host $REDIS_HOST --password $REDIS_PASSWORD --command set --key key --value value
```

## Get the value using the command line

And now we are going to retrieve the value using the command line:

```shell
  java -jar target/redis-lettuce.jar --host $REDIS_HOST --password $REDIS_PASSWORD --command get --key key
```

If everything went OK you should see:

```text
  value
```

<!-- workflow.run() 

  export RESULT=$(java -jar target/redis-lettuce.jar --host $REDIS_HOST --password $REDIS_PASSWORD --command get --key key)
  cd ../..

  -->

## Cleanup

<!-- workflow.directOnly() 

  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != value ]]; then
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
