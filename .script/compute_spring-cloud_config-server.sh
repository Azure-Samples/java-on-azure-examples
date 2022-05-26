#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
az extension add --name spring-cloud

export SPRING_CLOUD_NAME=springcloud-$RANDOM

az spring-cloud create \
--resource-group $RESOURCE_GROUP \
--name $SPRING_CLOUD_NAME

cd compute/spring-cloud/config-server

az spring-cloud config-server set \
--config-file application.yml \
--name ${SPRING_CLOUD_NAME} \
--resource-group ${RESOURCE_GROUP}

cd ../../..


az group delete --name $RESOURCE_GROUP --yes || true