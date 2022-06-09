#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION

if [[ -z $LOG_ANALYTICS_WORKSPACE ]]; then
export LOG_ANALYTICS_WORKSPACE=log-analytics-workspace-$RANDOM
az monitor log-analytics workspace create \
--resource-group $RESOURCE_GROUP \
--location $REGION \
--workspace-name $LOG_ANALYTICS_WORKSPACE
fi

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

export RESULT=`az monitor log-analytics workspace show  \
--resource-group $RESOURCE_GROUP \
--workspace-name $LOG_ANALYTICS_WORKSPACE \
--query provisioningState \
--output tsv`
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
exit 1
fi