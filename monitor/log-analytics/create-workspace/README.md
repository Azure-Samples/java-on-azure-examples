
# Create a Log Analytics workspace

[![monitor/log-analytics/create-workspace/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/monitor_log-analytics_create-workspace_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/monitor_log-analytics_create-workspace_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)

## Create a Log Analytics workspace

<!-- workflow.cron(0 1 * * 0) -->
<!-- workflow.include(../../../general/group/create/README.md) -->

To create the log analytics workspace use the following command line:

<!-- workflow.skip() -->
```shell
    
  export LOG_ANALYTICS_WORKSPACE=log-analytics-workspace-$RANDOM

  az monitor log-analytics workspace create \
      --resource-group $RESOURCE_GROUP \
      --location $REGION \
      --workspace-name $LOG_ANALYTICS_WORKSPACE

```

<!-- workflow.run()

  if [[ -z $LOG_ANALYTICS_WORKSPACE ]]; then
    export LOG_ANALYTICS_WORKSPACE=log-analytics-workspace-$RANDOM
    az monitor log-analytics workspace create \
      --resource-group $RESOURCE_GROUP \
      --location $REGION \
      --workspace-name $LOG_ANALYTICS_WORKSPACE
  fi

  -->

## Retrieve the Log Analytics Client ID and client secret

Once the log analytics workspace is created, you can get the log analytics 
client ID and the client secret using the command lines below:

```shell

  export LOG_ANALYTICS_WORKSPACE_CLIENT_ID=`az monitor log-analytics workspace show  \
    --resource-group $RESOURCE_GROUP \
    --workspace-name $LOG_ANALYTICS_WORKSPACE \
    --query customerId  \
    --output tsv`

  echo $LOG_ANALYTICS_WORKSPACE_CLIENT_ID

  export LOG_ANALYTICS_WORKSPACE_CLIENT_SECRET=`az monitor log-analytics workspace get-shared-keys \
    --resource-group $RESOURCE_GROUP \
    --workspace-name $LOG_ANALYTICS_WORKSPACE \
    --query primarySharedKey \
    --output tsv`

  echo $LOG_ANALYTICS_WORKSPACE_CLIENT_SECRET

```


## Cleanup

<!-- workflow.directOnly()

  export RESULT=`az monitor log-analytics workspace show  \
    --resource-group $RESOURCE_GROUP \
    --workspace-name $LOG_ANALYTICS_WORKSPACE \
    --query provisioningState \
    --output tsv`
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

* [Manage Azure log analytics](https://docs.microsoft.com/cli/azure/monitor/log-analytics)
* [Azure Log Analytics Documentation](https://docs.microsoft.com/azure/azure-monitor/logs/log-analytics-tutorial)

1m
