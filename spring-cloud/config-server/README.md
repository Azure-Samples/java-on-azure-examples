
# Configure the Azure Spring Cloud Config Server

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Spring Cloud instance](../create/)

## Configure the Azure Spring Cloud Config Server

To use the Azure Spring Cloud Config Server you need to give it a configuration
file that points to the Git repository you want to use. The command line below
sets the configuration of the Spring Cloud Config Server according to what is in
the `application.yml` file.

```shell
  az spring-cloud config-server set \
        --config-file application.yml \
        --name ${SPRING_CLOUD_NAME} \
        --resource-group ${RESOURCE_GROUP}
```

Note as a convenience (to keep everything in one Git repository) the `application.yml`
file specifies a `default-label`, which maps to the `spring-cloud-config-server`
branch of this Git repository.

## Cleanup

Do NOT forget to remove the resources you created once you are done with the example.
