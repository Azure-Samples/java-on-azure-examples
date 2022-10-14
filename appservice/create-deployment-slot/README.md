
# Create a deployment slot

[![appservice/create-deployment-slot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_create-deployment-slot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_create-deployment-slot_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)
1. [Deploy a web application on a managed Tomcat](../tomcat-helloworld/README.md)

## Create a deployment slot

<!-- workflow.cron(0 0 * * 6) -->
<!-- workflow.include(../tomcat-helloworld/README.md) -->

To create a deployment slot use the following command line:

```shell
  az webapp deployment slot create \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_TOMCAT_HELLOWORLD \
    --slot staging
```

The following command gives you the URL of the original web app:

```shell
  az webapp show --name $APPSERVICE_TOMCAT_HELLOWORLD \
                 --resource-group $RESOURCE_GROUP \
                 --query=defaultHostName
```

The following command gives you the URL of the web app that is in the staging slot:

```shell
  az webapp deployment slot list --name $APPSERVICE_TOMCAT_HELLOWORLD \
                                 --resource-group $RESOURCE_GROUP \
                                 --query='[0].defaultHostName'
```

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az webapp deployment slot list --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD  --output tsv --query '[0].state')
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Running ]]; then
    echo 'Deployment slot is NOT running'
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

1m

## Additional documentation

1. [Set up staging environments in Azure App Service](https://docs.microsoft.com/en-us/azure/app-service/deploy-staging-slots)
1. [Why Azure Deployment Slots are Awesome and How to Use Them](https://stackify.com/azure-deployment-slots/)
