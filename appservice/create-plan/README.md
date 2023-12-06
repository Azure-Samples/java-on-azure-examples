
# Create an App Service Plan

[![appservice/create-plan/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_create-plan_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_create-plan_README_md.yml)

## Prerequisites

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 8 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

## Create an App Service Plan

First, create the environment variable used for our App Service Plan
using the command line below:

<!-- workflow.skip() -->
```shell
  export APPSERVICE_PLAN=javazappsvcplan
```

<!-- workflow.run() 

  if [[ -z $APPSERVICE_PLAN ]]; then
    export APPSERVICE_PLAN=javazappsvcplan-$RANDOM
  fi

-->

Then, create the App Service Plan using the following command line:

```shell
  az appservice plan create \
    --resource-group $RESOURCE_GROUP \
    --location $REGION \
    --name $APPSERVICE_PLAN \
    --is-linux \
    --sku P1v3
```

<!-- workflow.directOnly() 

  export RESULT=$(az appservice plan show --resource-group $RESOURCE_GROUP --name $APPSERVICE_PLAN --query properties.provisioningState --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
