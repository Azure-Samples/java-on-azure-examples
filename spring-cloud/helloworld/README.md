
# Create a Spring Boot application and deploy it to Azure Spring Cloud

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Spring Cloud](../create/)

## Build the example

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

Note you will see exception occurring in the logs because you are not running the
application within the Azure Spring Cloud. Do not worry this expected and can be
ignored.

You can verify the application works by using your browser and going
to http://localhost:8080/

## Deploy the application to Azure Spring Cloud

```shell
  az spring-cloud app create \
    --name helloworld \
    --service ${SPRING_CLOUD_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --is-public true

  az spring-cloud app deploy \
    --name helloworld \
    --service ${SPRING_CLOUD_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --jar-path ./target/springcloud-helloworld.jar

  az spring-cloud app show \
    --name helloworld \
    --service ${SPRING_CLOUD_NAME} \
    --resource-group ${RESOURCE_GROUP} \
    --query properties.url \
    --output tsv
```

You can verify the application works, now on Azure Spring Cloud, by using your 
browser and going to the URL shown.

It should show you the following:

```text
Hello World
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

6m
