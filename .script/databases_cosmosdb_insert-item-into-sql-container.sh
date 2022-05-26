#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION

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


if [[ -z $COSMOSDB_SQL_DATABASE ]]; then
export COSMOSDB_SQL_DATABASE=sql-database-$RANDOM
az cosmosdb sql database create \
--resource-group $RESOURCE_GROUP \
--account-name $COSMOSDB_ACCOUNT_NAME \
--name $COSMOSDB_SQL_DATABASE
fi


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


if [[ -z $COSMOSDB_SQL_DATABASE ]]; then
export COSMOSDB_SQL_DATABASE=sql-database-$RANDOM
az cosmosdb sql database create \
--resource-group $RESOURCE_GROUP \
--account-name $COSMOSDB_ACCOUNT_NAME \
--name $COSMOSDB_SQL_DATABASE
fi


if [[ -z $COSMOSDB_SQL_CONTAINER ]]; then
export COSMOSDB_SQL_CONTAINER=sql-container-$RANDOM
az cosmosdb sql container create \
--resource-group $RESOURCE_GROUP \
--account-name $COSMOSDB_ACCOUNT_NAME \
--database-name $COSMOSDB_SQL_DATABASE \
--name $COSMOSDB_SQL_CONTAINER \
--partition-key-path '/id'
fi


cd databases/cosmosdb/insert-item-into-sql-container

mvn clean install
export COSMOSDB_ENDPOINT=$(az cosmosdb show --resource-group $RESOURCE_GROUP \
--name $COSMOSDB_ACCOUNT_NAME --output tsv --query documentEndpoint)

export COSMOSDB_MASTER_KEY=$(az cosmosdb keys list --name $COSMOSDB_ACCOUNT_NAME \
--resource-group $RESOURCE_GROUP --output tsv --query primaryMasterKey)

export RESULT=$(java -jar target/insert-item.jar)
cd ../../..


az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != "Item was added" ]]; then
echo "Failed to insert item into $COSMOSDB_SQL_CONTAINER"
exit 1
fi