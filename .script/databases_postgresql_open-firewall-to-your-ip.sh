#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
if [[ -z $POSTGRESQL_NAME ]]; then
export POSTGRESQL_NAME=postgresql-$RANDOM
export POSTGRESQL_USERNAME=postgresql
export POSTGRESQL_PASSWORD=p#ssw0rd-$RANDOM
fi
az postgres server create \
--admin-user $POSTGRESQL_USERNAME \
--admin-password $POSTGRESQL_PASSWORD \
--name $POSTGRESQL_NAME \
--resource-group $RESOURCE_GROUP \
--sku B_Gen5_1 \
--ssl-enforcement Disabled
export LOCAL_IP=`curl -s whatismyip.akamai.com`

az postgres server firewall-rule create \
--resource-group $RESOURCE_GROUP \
--server $POSTGRESQL_NAME \
--name AllowMyLocalIP \
--start-ip-address $LOCAL_IP \
--end-ip-address $LOCAL_IP

az group delete --name $RESOURCE_GROUP --yes || true