#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION

if [[ -z $MYSQL_NAME ]]; then
export MYSQL_NAME=mysql-$RANDOM
export MYSQL_USERNAME=mysql
export MYSQL_PASSWORD=p#ssw0rd-$RANDOM
fi

az mysql server create \
--admin-user $MYSQL_USERNAME \
--admin-password $MYSQL_PASSWORD \
--name $MYSQL_NAME \
--resource-group $RESOURCE_GROUP \
--sku B_Gen5_1 \
--ssl-enforcement Disabled

export RESULT=$(az mysql server show --name $MYSQL_NAME --resource-group $RESOURCE_GROUP --output tsv --query userVisibleState)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Ready ]]; then
echo "Provisioning MySQL " $MYSQL_NAME " failed"
exit 1
fi