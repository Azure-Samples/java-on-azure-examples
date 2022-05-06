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
az appservice plan delete \
--resource-group $RESOURCE_GROUP \
--name $APPSERVICE_PLAN \
--yes
export RESULT=$(az appservice plan show --resource-group $RESOURCE_GROUP --name $APPSERVICE_PLAN --query provisioningState --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" == Succeeded ]]; then
exit 1
fi