#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
fi

az group create --name $RESOURCE_GROUP --location $REGION
az extension add -n kusto

if [[ -z $ADX_CLUSTER_NAME ]]; then
export ADX_CLUSTER_NAME=adxcluster$RANDOM
az kusto cluster create \
--cluster-name $ADX_CLUSTER_NAME \
--resource-group $RESOURCE_GROUP \
--sku name="Standard_D13_v2" tier="Standard" \
--location $REGION \
--type SystemAssigned
fi


if [[ -z $ADX_DATABASE_NAME ]]; then
export ADX_DATABASE_NAME=adxdb$RANDOM
az kusto database create \
--cluster-name $ADX_CLUSTER_NAME \
--resource-group "$RESOURCE_GROUP" \
--database-name "$ADX_DATABASE_NAME" \
--read-write-database location="$REGION"
fi

export ADX_TABLE=Events