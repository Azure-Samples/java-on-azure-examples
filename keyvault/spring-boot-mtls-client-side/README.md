
# Create a Spring Boot mTLS client-side application

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/keyvault_spring-boot-mtls-client-side_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/keyvault_spring-boot-mtls-client-side_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../group/create/README.md)
1. [Create an Azure Key Vault](../create/README.md)
1. [Create a self-signed certificate](../create-self-signed-certificate/README.md)
1. Create a 'read-only' Service Principal
1. Create an access policy
1. [Create a Spring Boot mTLS server-side application](../spring-boot-mtls-server-side/README.md)

## Build the example

To build the JAR file use the following Maven command line.

```shell
  mvn package
```

## Run example

To run the example locally use the following Maven command line.

<!-- workflow.skip() -->
```shell
  mvn spring-boot:run
```

You can verify the application works by using your browser and going
to http://localhost:8080/hello

It should show you the following:

```text
Hello mTLS
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Reference material

1. [Azure Key Vault Certificates Spring Boot starter](https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/spring/azure-spring-boot-starter-keyvault-certificates)
1. [Maven](https://maven.apache.org/README.md)
1. [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/README.md)
1. [Spring Boot](https://spring.io/projects/spring-boot)
