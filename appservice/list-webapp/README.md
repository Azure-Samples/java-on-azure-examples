
# List your web applications

[![appservice/list-webapp/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_list-webapp_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_list-webapp_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)
1. [Deploy a web application on a managed Tomcat](../tomcat-helloworld/README.md)

## List your web applications

<!-- workflow.cron(0 0 * * 4) -->
<!-- workflow.include(../tomcat-helloworld/README.md) -->

To list the web applications use the following command line:

```shell
  az webapp list --resource-group $RESOURCE_GROUP
```

<!-- workflow.directOnly

  export RESULT=$(az webapp list --resource-group $RESOURCE_GROUP --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != "" ]]; then
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
