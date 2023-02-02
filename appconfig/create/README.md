
# Create an Azure App Configuration

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appconfig_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appconfig_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.cron(0 0 * * 2) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure App Configuration

To create the Azure App Configuration use the following command lines:

```shell
  export APP_CONFIG_NAME=appconfig-$RANDOM

  az appconfig create \
    --resource-group $RESOURCE_GROUP \
    --location $REGION \
    --name $APP_CONFIG_NAME \
    --enable-public-network true
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  export RESULT=$(az appconfig show --resource-group $RESOURCE_GROUP --name $APP_CONFIG_NAME --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo 'App Configuration was not provisioned'
    exit 1
  fi

  -->

## More information

1. [Azure CLI](https://docs.microsoft.com/cli/azure/appconfig)
1. [Azure App Configuration - documentation](https://learn.microsoft.com/azure/azure-app-configuration)
