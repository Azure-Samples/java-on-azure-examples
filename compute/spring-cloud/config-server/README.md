
# Configure the Azure Spring Cloud Config Server

[![compute/spring-cloud/config-server/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/compute_spring-cloud_config-server_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/compute_spring-cloud_config-server_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)
1. [Create an Azure Spring Cloud instance](../create/README.md)

<!-- workflow.cron(0 17 * * 2) -->
<!-- workflow.include(../create/README.md) -->
<!-- workflow.run() 

cd compute/spring-cloud/config-server

  -->

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

<!-- workflow.run() 

cd ../../..

  -->

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources you created once you are done with the example.

## Reference documentation

1. [Commands to manage Azure Spring Cloud](https://docs.microsoft.com/cli/azure/spring-cloud)
1. [Azure Spring Cloud Documentation](https://docs.microsoft.com/azure/spring-cloud/)
1. [Quickstart: Set up Azure Spring Cloud Config Server](https://docs.microsoft.com/azure/spring-cloud/quickstart-setup-config-server?pivots=programming-language-java)

2m
