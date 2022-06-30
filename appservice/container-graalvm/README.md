
# Deploy a GraalVM application using a container image

[![appservice/container-graalvm/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_container-graalvm_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_container-graalvm_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Build and push a GraalVM application to ACR](../../acr/graalvm/README.md)
1. [Create settings.xml using admin access keys](../../acr/create-settings-xml/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)

## Deploy the GraalVM application using a container image

<!-- workflow.cron(0 10 * * 5) -->
<!-- workflow.include(../../acr/graalvm/README.md) -->
<!-- workflow.include(../../acr/create-settings-xml/README.md) -->
<!-- workflow.include(../create-plan/README.md) -->
<!-- workflow.run() 

  cd appservice/container-graalvm

  -->

To deploy the example use the following command lines:

```shell
  export APPSERVICE_CONTAINER_GRAALVM=appservice-container-graalvm-$RANDOM

  mvn azure-webapp:deploy \
    --settings=$SETTINGS_XML \
    -DappName=$APPSERVICE_CONTAINER_GRAALVM \
    -DimageName=$ACR_GRAALVM_IMAGE \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP \
    -DserverId=$ACR_NAME

  echo `az webapp show \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_CONTAINER_GRAALVM \
    --query 'hostNames[0]' \
    --output tsv`/hello
```

<!-- workflow.run() 

  sleep 180
  cd ../..

  -->

Then open your browser to the URL shown as output and you should see:

```text
Hello
```

<!-- workflow.directOnly()

  export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_CONTAINER_GRAALVM --output tsv --query state)
  if [[ "$RESULT" != Running ]]; then
    echo 'Web application is NOT running'
    az group delete --name $RESOURCE_GROUP --yes || true
    exit 1
  fi
  export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_CONTAINER_GRAALVM --output tsv --query defaultHostName)/hello
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello"* ]]; then
    echo "Response did not contain 'Hello'"
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
| `imageName`            | the image name             |
| `registry`             | the Azure Container Registry name |
| `registryUrl`          | the Azure Container Registry url  |
| `resourceGroup`        | the Azure Resource Group name     |
| `serverId`             | the Maven server id               |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m
