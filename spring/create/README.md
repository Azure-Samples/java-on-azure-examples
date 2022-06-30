
# Create an Azure Spring Apps environment

[![spring/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.cron(0 0 * * 3) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Spring Apps environment

To create the Azure Spring Apps environment use the following command lines:

```shell
  az extension add --name spring

  export SPRING_NAME=spring-$RANDOM

  az spring create \
    --resource-group $RESOURCE_GROUP \
    --name $SPRING_NAME
```

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az spring show --resource-group $RESOURCE_GROUP --name $SPRING_NAME --output tsv --query properties.provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Deploy a Hello World Spring Boot application](../helloworld/README.md)
* [Configure the Azure Spring Apps Config Server](../config-server/README.md)

## Reference documentation

* [Commands to manage Azure Spring Apps](https://docs.microsoft.com/cli/azure/spring)
* [Azure Spring Cloud Documentation](https://docs.microsoft.com/azure/spring-cloud/)

6m
