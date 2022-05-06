#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
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

cd compute/appservice/javase-quarkus

mvn package
export APPSERVICE_JAVASE_QUARKUS=appservice-javase-quarkus-$RANDOM

mvn azure-webapp:deploy \
-DappName=$APPSERVICE_JAVASE_QUARKUS \
-DappServicePlan=$APPSERVICE_PLAN \
-DresourceGroup=$RESOURCE_GROUP

cd ../../..


sleep 60

export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_JAVASE_QUARKUS --output tsv --query state)
if [[ "$RESULT" != Running ]]; then
echo 'Web application is NOT running'
az group delete --name $RESOURCE_GROUP --yes || true
exit 1
fi

sleep 60

export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_JAVASE_QUARKUS --output tsv --query defaultHostName)
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"Hello"* ]]; then
echo "Response did not contain 'Hello'"
exit 1
fi