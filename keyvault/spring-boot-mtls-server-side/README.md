
# Create a Spring Boot mTLS server-side application

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Key Vault](../create/)
1. Create a self-signed certificate
1. Create a 'read-only' Service Principal
1. Create an access policy

## Build the example

To build the JAR file use the following Maven command line.

```shell
  mvn package
```

## Run example

To run the example use the following Maven command line.

<!-- workflow.skip() -->
```shell
  mvn spring-boot:run
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
