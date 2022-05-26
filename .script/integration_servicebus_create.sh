#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
export SERVICE_BUS=service-bus-$RANDOM
az servicebus namespace create \
--resource-group $RESOURCE_GROUP \
--name $SERVICE_BUS \
--sku Premium \
--location $REGION
export RESULT=$(az servicebus namespace show --resource-group $RESOURCE_GROUP --name $SERVICE_BUS --query provisioningState --output tsv)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
exit 1
fi