#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
fi

az group create --name $RESOURCE_GROUP --location $REGION
az extension add --name spring-cloud

export SPRING_CLOUD_NAME=springcloud-$RANDOM

az spring-cloud create \
--resource-group $RESOURCE_GROUP \
--name $SPRING_CLOUD_NAME

export RESULT=$(az spring-cloud show --resource-group $RESOURCE_GROUP --name $SPRING_CLOUD_NAME --output tsv --query properties.provisioningState)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != Succeeded ]]; then
exit 1
fi