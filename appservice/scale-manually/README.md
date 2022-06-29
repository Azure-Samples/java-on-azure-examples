
# Scale your App Service Plan manually

[![appservice/scale-manually/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_scale-manually_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_scale-manually_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an App Service plan](../create-plan/README.md)
1. [Deploy a web application on a managed Tomcat](../tomcat-helloworld/README.md)

## Scale the App Service Plan

To scale the App Service Plan use the following command line:

<!-- workflow.cron(0 8 * * 5) -->
<!-- workflow.include(../tomcat-helloworld/README.md) -->

```shell
  az appservice plan update \
    --verbose \
    --name $APPSERVICE_PLAN \
    --resource-group $RESOURCE_GROUP \
    --number-of-workers 2
```

You can adjust the number to your desired number of workers.

<!-- workflow.directOnly()

  export RESULT=$(az appservice plan show --name $APPSERVICE_PLAN --resource-group $RESOURCE_GROUP --output tsv --query sku.capacity)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != "2" ]]; then
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove resources once you are done running the example.
