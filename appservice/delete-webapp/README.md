
# Delete a web application

[![appservice/delete-webapp/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_delete-webapp_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_delete-webapp_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../group/create/)
1. [Deploy a web application on a managed Tomcat](../tomcat-helloworld/)

## Delete a web application

<!-- workflow.cron(0 6 * * 1) -->
<!-- workflow.include(../tomcat-helloworld/README.md) -->

To delete the web application from Azure App Service use the following command
line:

```shell
  az webapp delete --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD
```

Note you can substitute $APPSERVICE_TOMCAT_HELLOWORLD with the name of any web 
application you want to delete in your resource group.

<!-- workflow.directOnly() 

export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_TOMCAT_HELLOWORLD --output tsv --query state)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" == Running ]]; then
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
