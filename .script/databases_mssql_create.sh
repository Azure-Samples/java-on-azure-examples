#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
export MSSQL_NAME=mssql-$RANDOM
export MSSQL_USERNAME=mssql
export MSSQL_PASSWORD=p#ssw0rd-$RANDOM
if [[ -z $MSSQL_NAME ]]; then
export MSSQL_NAME=mssql-$RANDOM
export MSSQL_USERNAME=mssql
export MSSQL_PASSWORD=p#ssw0rd-$RANDOM
fi
az sql server create \
--admin-user $MSSQL_USERNAME \
--admin-password $MSSQL_PASSWORD \
--name $MSSQL_NAME \
--resource-group $RESOURCE_GROUP

az group delete --name $RESOURCE_GROUP --yes || true