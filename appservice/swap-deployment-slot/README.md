
# Swap a deployment slot

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../../create-plan/)
1. [Deploy a web application on a managed Tomcat](../tomcat-helloworld/)
1. [Create a deployment slot](../create-deployment-slot/)
1. [Deploy to a deployment slot](../deploy-to-deployment-slot/)

## Swap a deployment slot

<!-- workflow.cron(0 8 * * 1) -->
<!-- workflow.include(../deploy-to-deployment-slot/README.md) -->

To swap deployment slot use the following command line:

```shell
  az webapp deployment slot swap \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_TOMCAT_HELLOWORLD \
    --slot staging
```

<!-- workflow.directOnly() 

export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --output tsv --query state)
if [[ "$RESULT" != Running ]]; then
  echo 'Web application is NOT running'
  az group delete --name $RESOURCE_GROUP --yes || true
  exit 1
fi

export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --output tsv --query defaultHostName)
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"Hello Staging"* ]]; then
  echo "Response did not contain 'Hello Staging'"
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
