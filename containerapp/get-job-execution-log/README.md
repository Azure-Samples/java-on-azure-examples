# Get job execution log

[![containerapp/get-job-execution-log/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_get-job-execution-log_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_get-job-execution-log_README_md.yml)

## Prerequisites

<!-- 

  if [[ -z $REGION ]]; then
    export REGION=westus2
  fi

  -->
<!-- workflow.cron(0 9 * * 3) -->
<!-- workflow.include(../../acr/helloworldjob/README.md) -->
<!-- workflow.include(../list-job-executions/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Build and push a Hello World Job application to Azure Container Registry](../../acr/helloworldjob/README.md)
1. [Create an 'acrpull' Service Principal](../../acr/create-acrpull-service-principal/README.md)
1. [Create an Azure Container Apps environment](../create-environment/README.md)
1. [Create a manual job](../create-manual-job/README.md)
1. [Execute a manual job](../execute-manual-job/README.md)
1. [List job executions](../list-job-executions/README.md)

## Get job execution log

Get the Log Analytics workspace ID by executing the command below:

```shell
  export ACA_LOG_ANALYTICS_WORKSPACE_ID=`az containerapp env show \
    --name $ACA_ENVIRONMENT_NAME \
    --resource-group $RESOURCE_GROUP \
    --query "properties.appLogsConfiguration.logAnalyticsConfiguration.customerId" \
    --output tsv`
```

Get the name of the latest job execution using the command line below:

```shell
  export ACA_JOB_EXECUTION_NAME=`az containerapp job execution list \
    --name $ACA_JOB_NAME \
    --resource-group $RESOURCE_GROUP \
    --query "[0].name" \
    --output tsv`
```

Use the command line below to get the job execution log:

<!-- workflow.skip() -->
```shell
  sleep 45
  az monitor log-analytics query \
    --workspace $ACA_LOG_ANALYTICS_WORKSPACE_ID \
    --analytics-query "ContainerAppConsoleLogs_CL | where ContainerGroupName_s startswith '$ACA_JOB_EXECUTION_NAME' | order by _timestamp_d asc" \
    --query "[].Log_s"
``` 

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
