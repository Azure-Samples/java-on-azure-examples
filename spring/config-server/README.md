
# Configure the Azure Spring Apps Config Server

[![spring/config-server/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring_config-server_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring_config-server_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Spring Apps environment](../create/README.md)

<!-- workflow.cron(0 3 * * 3) -->
<!-- workflow.include(../create/README.md) -->
<!-- workflow.run() 

  cd spring/config-server

  -->

## Configure the Azure Spring Apps Config Server

To use the Azure Spring Apps Config Server you need to give it a configuration
file that points to the Git repository you want to use. The command line below
sets the configuration of the Azure Spring Apps Config Server according to what
is in the `application.yml` file.

```shell
  az spring config-server set \
        --config-file application.yml \
        --name ${SPRING_NAME} \
        --resource-group ${RESOURCE_GROUP}
```

Note as a convenience (to keep everything in one Git repository) the `application.yml`
file specifies a `default-label`, which maps to the `spring-cloud-config-server`
branch of this Git repository.

<!-- workflow.run() 

  cd ../..

  -->

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources you created once you are done with the example.

## Reference documentation

1. [Commands to manage Azure Spring Apps](https://docs.microsoft.com/cli/azure/spring)
1. [Azure Spring Cloud Documentation](https://docs.microsoft.com/azure/spring-cloud/)
1. [Quickstart: Set up Azure Spring Cloud Config Server](https://docs.microsoft.com/azure/spring-cloud/quickstart-setup-config-server?pivots=programming-language-java)

2m
