#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION

if [[ -z $COSMOSDB_ACCOUNT_NAME ]]; then
export COSMOSDB_ACCOUNT_NAME=cosmosdb-$RANDOM
az cosmosdb create \
--name $COSMOSDB_ACCOUNT_NAME \
--resource-group $RESOURCE_GROUP \
--locations regionName=eastus failoverPriority=0
fi


export RESULT=$(az cosmosdb show --name $COSMOSDB_ACCOUNT_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
echo "Failed to create Cosmos DB account $COSMOSDB_ACCOUNT_NAME"
exit 1
fi