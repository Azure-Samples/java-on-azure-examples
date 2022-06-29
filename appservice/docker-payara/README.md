
# Deploy Payara using a Docker image

[![appservice/docker-payara/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-payara_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-payara_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Push a Payara Docker image to Azure Container Registry](../../acr/payara/README.md)
1. [Create settings.xml using admin access keys](../../acr/create-settings-xml/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)

## Deploy Payara using a Docker image

<!-- workflow.cron(0 12 * * 5) -->
<!-- workflow.include(../../acr/payara/README.md) -->
<!-- workflow.include(../../acr/create-settings-xml/README.md) -->
<!-- workflow.include(../create-plan/README.md) -->

To deploy Payara use the following command lines:

<!-- workflow.run() 

  cd appservice/docker-payara

  -->

```shell
  export APPSERVICE_DOCKER_PAYARA=appservice-docker-payara-$RANDOM

  mvn azure-webapp:deploy \
    --settings=$SETTINGS_XML \
    -DappName=$APPSERVICE_DOCKER_PAYARA \
    -DimageName=$ACR_PAYARA_IMAGE \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP \
    -DserverId=$ACR_NAME

  az webapp show \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_DOCKER_PAYARA \
    --query hostNames[0] \
    --output tsv
```

<!-- workflow.run() 

  sleep 180
  cd ../..

  -->

Then open your browser to the URL shown as output and you should see:

```text
And this is served by a custom Payara using a Docker image coming from our 
own Azure Container Registry.
```

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

<!-- workflow.directOnly()

  export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_PAYARA --output tsv --query state)
  if [[ "$RESULT" != Running ]]; then
    echo 'Web application is NOT running'
    az group delete --name $RESOURCE_GROUP --yes || true
    exit 1
  fi
  export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_PAYARA --output tsv --query defaultHostName)
  export RESULT=$(curl $URL)
  sleep 180
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"custom Payara"* ]]; then
    echo "Response did not contain 'custom Payara'"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

3m
