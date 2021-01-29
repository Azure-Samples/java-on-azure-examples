
# Delete an App Service Plan

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../group/create/)
1. [Create an Azure App Service Plan](../create-plan/)

## Delete an App Service Plan

<!-- workflow.cron(0 2 * * 1) -->
<!-- workflow.include(../create-plan/README.md) -->

To delete the Azure App Service Plan use the following command line:

```shell
  az appservice plan delete \
    --resource-group $RESOURCE_GROUP \
    --name $APPSERVICE_PLAN \
    --yes
```

<!-- workflow.directOnly() 
export RESULT=$(az appservice plan show --resource-group $RESOURCE_GROUP --name $APPSERVICE_PLAN --query provisioningState --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" == Succeeded ]]; then
  exit 1
fi
  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
