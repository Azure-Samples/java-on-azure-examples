# List job executions

[![containerapp/list-job-executions/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_list-job-executions_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_list-job-executions_README_md.yml)

## Prerequisites

<!-- 

  if [[ -z $REGION ]]; then
    export REGION=southcentralus
  fi

  -->
<!-- workflow.cron(0 8 * * 1) -->
<!-- workflow.include(../../acr/helloworldjob/README.md) -->
<!-- workflow.include(../execute-manual-job/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Build and push a Hello World Job application to Azure Container Registry](../../acr/helloworldjob/README.md)
1. [Create an Azure Container Apps environment](../create-environment/README.md)
1. [Create a manual job](../create-manual-job/README.md)
1. [Execute a manual job](../execute-manual-job/README.md)

## List job executions

To list executions for a job use the command line below.

```shell
  az containerapp job execution list \
    --name $ACA_JOB_NAME \
    --resource-group $RESOURCE_GROUP
```

<!-- workflow.directOnly()

  sleep 60
  az group delete --name $RESOURCE_GROUP --yes || true

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
