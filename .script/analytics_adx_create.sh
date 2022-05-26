#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
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


export RESULT=$(az kusto cluster show --name $ADX_CLUSTER_NAME \
--resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
echo "Failed to create Azure Data Explorer cluster $ADX_CLUSTER_NAME"
exit 1
fi