
# Create a deployment slot

[![appservice/create-deployment-slot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_create-deployment-slot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_create-deployment-slot_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure App Service Plan](../create-plan/)
1. [Deploy a web application on a managed Tomcat](../tomcat-helloworld/)

## Create a deployment slot

<!-- workflow.cron(0 8 * * 1) -->
<!-- workflow.include(../tomcat-helloworld/README.md) -->

To create a deployment slot use the following command line:

```shell
  az webapp deployment slot create \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_TOMCAT_HELLOWORLD \
    --slot staging
```

## Cleanup

<!-- workflow.directOnly()

export RESULT=$(az webapp deployment slot list --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD  --output tsv --query [0].state)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != Running ]]; then
  echo 'Deployment slot is NOT running'
  exit 1
fi
  -->

Do NOT forget to remove the resources once you are done running the example.

1m
