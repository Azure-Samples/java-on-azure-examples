
# Create an App Service Plan

![appservice/create-plan/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/appservice/create-plan/README.md/badge.svg)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

## Create an App Service Plan

<!-- workflow.cron(0 1 * * 1) -->
<!-- workflow.include(../../group/create/README.md) -->

First, create the environment variable used for our App Service Plan
using the command line below:

<!-- workflow.skip() -->
```shell
  export APPSERVICE_PLAN=appservice-plan
```

<!-- workflow.run() 
if [[ -z $APPSERVICE_PLAN ]]; then
  export APPSERVICE_PLAN=appservice-plan-$RANDOM
fi
-->

Then, create the App Service Plan using the following command line:

```shell
  az appservice plan create \
    --resource-group $RESOURCE_GROUP \
    --location $REGION \
    --name $APPSERVICE_PLAN \
    --is-linux \
    --sku P1V2
```

<!-- workflow.directOnly() 
export RESULT=$(az appservice plan show --resource-group $RESOURCE_GROUP --name $APPSERVICE_PLAN --query provisioningState --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
  exit 1
fi
  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
