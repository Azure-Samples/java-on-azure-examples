
# Create an Azure Spring Cloud

[![compute/spring-cloud/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/compute_spring-cloud_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/compute_spring-cloud_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)

<!-- workflow.include(../../../general/group/create/README.md) -->

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

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources once you are done running the example.

6m
