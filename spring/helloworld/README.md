
# Deploy a Hello World Spring Boot application

[![spring/helloworld/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring_helloworld_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring_helloworld_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Deploy an Azure Spring Apps environment](../create/README.md)

<!-- workflow.cron(0 2 * * 3) -->
<!-- workflow.include(../create/README.md) -->

## Build the example

<!-- workflow.run() 

  cd spring/helloworld

  -->

To build the JAR file use the following Maven command line.

```shell
  mvn package
```

## Run example locally

To run the example locally use the following Maven command line.

<!-- workflow.skip() -->
```shell
  mvn spring-boot:run
```

Note you will see exceptions occurring in the logs because you are not running
the application within the Azure Spring Apps environment. Do not worry this
expected and can be ignored.

## Deploy the Hello World Spring Boot application to Azure Spring Cloud

```shell
  az spring app create \
    --name helloworld \
    --service ${SPRING_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --assign-endpoint \
    --runtime-version Java_11 \
    --verbose

  az spring app deploy \
    --name helloworld \
    --service ${SPRING_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --artifact-path ./target/spring-helloworld.jar \
    --verbose

  az spring app show \
    --name helloworld \
    --service ${SPRING_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --query properties.url \
    --output tsv
```

You can verify the application works, now on Azure Spring Apps, by using your 
browser and going to the URL shown.

It should show you the following:

```text
Hello World
```

## Cleanup

<!-- workflow.directOnly()

  export URL=$(az spring app show \
    --name helloworld \
    --service ${SPRING_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --query properties.url \
    --output tsv)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello World"* ]]; then
    echo "Response did not contain 'Hello World'"
    exit 1
  fi
  
  -->

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

1. [Commands to manage Azure Spring Apps](https://docs.microsoft.com/cli/azure/spring)
1. [Azure Spring Cloud Documentation](https://docs.microsoft.com/azure/spring-cloud/)
1. [Quickstart: Build and deploy apps to Azure Spring Cloud](https://docs.microsoft.com/azure/spring-cloud/quickstart-deploy-apps?pivots=programming-language-java)

6m
