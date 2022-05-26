#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
export REDIS_NAME=redis-$RANDOM

az redis create \
--location $REGION \
--name $REDIS_NAME \
--resource-group $RESOURCE_GROUP \
--sku Basic \
--vm-size c0

sleep 3000


export RESULT=$(az redis show --resource-group $RESOURCE_GROUP --name $REDIS_NAME --query provisioningState --output tsv)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != Succeeded ]]; then
exit 1
fi