#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
if [[ -z $APPSERVICE_PLAN ]]; then
export APPSERVICE_PLAN=appservice-plan-$RANDOM
fi
az appservice plan create \
--resource-group $RESOURCE_GROUP \
--location $REGION \
--name $APPSERVICE_PLAN \
--is-linux \
--sku P1v3

cd compute/appservice/tomcat-helloworld

mvn clean install
export APPSERVICE_TOMCAT_HELLOWORLD=appservice-tomcat-helloworld-$RANDOM
mvn azure-webapp:deploy \
-DappName=$APPSERVICE_TOMCAT_HELLOWORLD \
-DappServicePlan=$APPSERVICE_PLAN \
-DresourceGroup=$RESOURCE_GROUP

sleep 60
cd ../../..

az appservice plan update \
--verbose \
--name $APPSERVICE_PLAN \
--resource-group $RESOURCE_GROUP \
--number-of-workers 2

export RESULT=$(az appservice plan show --name $APPSERVICE_PLAN --resource-group $RESOURCE_GROUP --output tsv --query sku.capacity)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != "2" ]]; then
exit 1
fi