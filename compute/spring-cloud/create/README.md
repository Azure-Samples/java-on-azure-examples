
# Create an Azure Spring Cloud

[![compute/spring-cloud/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/compute_spring-cloud_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/compute_spring-cloud_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)

<!-- workflow.cron(0 16 * * 2) -->
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

  export RESULT=$(az spring-cloud show --resource-group $RESOURCE_GROUP --name $SPRING_CLOUD_NAME --output tsv --query properties.provisioningState)
  
  az group delete --name $RESOURCE_GROUP --yes || true

  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Deploy a Hello World Spring Boot application to Azure Spring Cloud](../helloworld/README.md)
* [Configure the Azure Spring Cloud Config Server](../config-server/README.md)

## Reference documentation

* [Commands to manage Azure Spring Cloud](https://docs.microsoft.com/cli/azure/spring-cloud)
* [Azure Spring Cloud Documentation](https://docs.microsoft.com/azure/spring-cloud/)

6m
