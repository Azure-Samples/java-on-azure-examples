
# Deploy to a deployment slot

[![appservice/deploy-to-deployment-slot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_deploy-to-deployment-slot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_deploy-to-deployment-slot_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)
1. [Deploy a web application on a managed Tomcat](../tomcat-helloworld/README.md)
1. [Create a deployment slot](../create-deployment-slot/README.md)

## Build the example

<!-- workflow.cron(0 6 * * 5) -->
<!-- workflow.include(../create-deployment-slot/README.md) -->
<!-- workflow.run() 

  cd appservice/deploy-to-deployment-slot

  -->

````shell
  mvn clean install
````

## Deploy to a deployment slot

````shell
  mvn azure-webapp:deploy \
    -DappName=$APPSERVICE_TOMCAT_HELLOWORLD \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP \
    -DdeploymentSlotName=staging
````

<!-- workflow.run()

  sleep 60
  cd ../..

  -->

<!-- workflow.directOnly() 

  export RESULT=$(az webapp deployment slot list --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --output tsv --query '[0].state')
  if [[ "$RESULT" != Running ]]; then
    echo 'Deployment slot is NOT running'
    az group delete --name $RESOURCE_GROUP --yes || true
    exit 1
  fi
  sleep 60
  export URL=https://$(az webapp deployment slot list --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --output tsv --query '[0].defaultHostName')
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello Staging"* ]]; then
    echo "Response did not contain 'Hello Staging'"
    exit 1
  fi

  -->

Once the command completes you will be able to see the example by using your web
browser and going to the `xxxxx.azurewebsites.net` address the command echoes.

You can also get the URL by using the following command:

```text
  az webapp deployment slot list \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_TOMCAT_HELLOWORLD \
    --output tsv \
    --query '[0].defaultHostName'
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
