
# Create an Azure Spring Cloud

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)

## Create the Azure Spring Cloud

To create the Azure Spring Cloud use the following command lines:

```shell
  az extension add --name spring-cloud

  export SPRING_CLOUD_NAME=springcloud-$RANDOM

  az spring-cloud create \
    --resource-group $RESOURCE_GROUP \
    --name $SPRING_CLOUD_NAME
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

6m
