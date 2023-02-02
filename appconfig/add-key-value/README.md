
# Adding a Value to Azure App Configuration

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appconfig_add-key-value_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appconfig_add-key-value_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure App Configuration](../create/README.md)

<!-- workflow.cron(0 1 * * 2) -->
<!-- workflow.include(../create/README.md) -->

## Add a Key/Value to Azure App Configuration

To add a Key/Value to the Azure App Configuration use the command line below (`yes` does not prompt for confirmation):

```shell
  az appconfig kv set \
    --name $APP_CONFIG_NAME \
    --key myKey \
    --value "My value" \
    --yes
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  export RESULT=$(az appconfig kv show --name $APP_CONFIG_NAME --key myKey --query value --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != "My value" ]]; then
    echo 'Key/Value was not properly set'
    exit 1
  fi

  -->

## More information

1. [Azure CLI](https://docs.microsoft.com/cli/azure/appconfig/kv)
1. [Azure App Configuration Key Value - documentation](https://learn.microsoft.com/azure/azure-app-configuration/concept-key-value)
