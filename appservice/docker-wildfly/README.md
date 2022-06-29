
# Deploy WildFly using a Docker image

[![appservice/docker-wildfly/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-wildfly_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-wildfly_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Push a WildFly Docker image to Azure Container Registry](../../acr/wildfly/README.md)
1. [Create settings.xml using admin access keys](../../acr/create-settings-xml/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)

## Deploy WildFly using a Docker image

<!-- workflow.cron(0 14 * * 5) -->
<!-- workflow.include(../../acr/wildfly/README.md) -->
<!-- workflow.include(../../acr/create-settings-xml/README.md) -->
<!-- workflow.include(../create-plan/README.md) -->
<!-- workflow.run() 

  cd appservice/docker-wildfly

  -->

To deploy WildFly use the following command lines:

```shell
  export APPSERVICE_DOCKER_WILDFLY=appservice-docker-wildfly-$RANDOM

  mvn azure-webapp:deploy \
    --settings=$SETTINGS_XML \
    -DappName=$APPSERVICE_DOCKER_WILDFLY \
    -DimageName=$ACR_WILDFLY_IMAGE \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP \
    -DserverId=$ACR_NAME

  az webapp show \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_DOCKER_WILDFLY \
    --query hostNames[0] \
    --output tsv
```

<!-- workflow.run() 

  sleep 60
  cd ../../..

  -->

Then open your browser to the URL shown as output and you should see:

```text
And this is served by a custom WildFly using a Docker image coming from our 
own Azure Container Registry.
```

<!-- workflow.directOnly()

  export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_WILDFLY --output tsv --query state)
  if [[ "$RESULT" != Running ]]; then
    echo 'Web application is NOT running'
    az group delete --name $RESOURCE_GROUP --yes || true
    exit 1
  fi
  export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_WILDFLY --output tsv --query defaultHostName)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"custom WildFly"* ]]; then
    echo "Response did not contain 'custom WildFly'"
    exit 1
  fi

  -->

## Properties supported by the example

The example supports the following properties that you can pass in as -Dname=value
to the Maven command line to customize your deployment.

| name                   | description                       |
|------------------------|-----------------------------------|
| `appName`              | the application name              |
| `appServicePlan`       | the App Service plan to use       |
| `imageName`            | the Docker image name             |
| `serverId`             | the Maven server id               |
| `registry`             | the Azure Container Registry name |
| `registryUrl`          | the Azure Container Registry url  |
| `resourceGroup`        | the Azure Resource Group name     |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m
