
# Create an Azure Cache for Redis

[![databases/redis/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/databases_redis_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/databases_redis_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)

<!-- workflow.cron(0 15 * * 2) -->
<!-- workflow.include(../../../general/group/create/README.md) -->

## Create the Azure Cache for Redis

To create the Azure Cache for Redis use the following command line:

````shell
  export REDIS_NAME=redis-$RANDOM

  az redis create \
    --location $REGION \
    --name $REDIS_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku Basic \
    --vm-size c0
````

## Cleanup

<!-- workflow.directOnly() 

  export RESULT=$(az redis show --resource-group $RESOURCE_GROUP --name $REDIS_NAME --query provisioningState --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

15m
