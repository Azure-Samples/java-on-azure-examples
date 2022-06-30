
# Create a Log Analytics workspace

[![monitor/create-log-analytics-workspace/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/monitor_create-log-analytics-workspace_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/monitor_create-log-analytics-workspace_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

## Create a Log Analytics workspace

<!-- workflow.cron(0 0 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->

To create the log analytics workspace use the following command line:

<!-- workflow.skip() -->
```shell
    
  export MONITOR_LOG_ANALYTICS_WORKSPACE=log-analytics-workspace-$RANDOM

  az monitor log-analytics workspace create \
      --resource-group $RESOURCE_GROUP \
      --location $REGION \
      --workspace-name $MONITOR_LOG_ANALYTICS_WORKSPACE

```

<!-- workflow.run()

  if [[ -z $MONITOR_LOG_ANALYTICS_WORKSPACE ]]; then
    export MONITOR_LOG_ANALYTICS_WORKSPACE=log-analytics-workspace-$RANDOM
    az monitor log-analytics workspace create \
      --resource-group $RESOURCE_GROUP \
      --location $REGION \
      --workspace-name $MONITOR_LOG_ANALYTICS_WORKSPACE
  fi

  -->

## Retrieve the Log Analytics Client ID and client secret

Once the log analytics workspace is created, you can get the log analytics 
client ID and the client secret using the command lines below:

```shell

  export MONITOR_LOG_ANALYTICS_WORKSPACE_CLIENT_ID=`az monitor log-analytics workspace show  \
    --resource-group $RESOURCE_GROUP \
    --workspace-name $MONITOR_LOG_ANALYTICS_WORKSPACE \
    --query customerId  \
    --output tsv`

  echo $MONITOR_LOG_ANALYTICS_WORKSPACE_CLIENT_ID

  export MONITOR_LOG_ANALYTICS_WORKSPACE_CLIENT_SECRET=`az monitor log-analytics workspace get-shared-keys \
    --resource-group $RESOURCE_GROUP \
    --workspace-name $MONITOR_LOG_ANALYTICS_WORKSPACE \
    --query primarySharedKey \
    --output tsv`

  echo $MONITOR_LOG_ANALYTICS_WORKSPACE_CLIENT_SECRET

```


## Cleanup

<!-- workflow.directOnly()

  export RESULT=`az monitor log-analytics workspace show  \
    --resource-group $RESOURCE_GROUP \
    --workspace-name $MONITOR_LOG_ANALYTICS_WORKSPACE \
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
