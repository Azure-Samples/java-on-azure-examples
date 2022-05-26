#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
if [[ -z $ACR_NAME ]]; then
export ACR_NAME=acreg$RANDOM
fi
az acr create \
--name $ACR_NAME \
--resource-group $RESOURCE_GROUP \
--sku Basic \
--admin-enabled true

cd containers/acr/jetty

mvn package
export ACR_JETTY_IMAGE=jetty:latest

az acr build --resource-group $RESOURCE_GROUP --registry $ACR_NAME --image $ACR_JETTY_IMAGE .

cd ../../..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
if [[ -z $ACR_NAME ]]; then
export ACR_NAME=acreg$RANDOM
fi
az acr create \
--name $ACR_NAME \
--resource-group $RESOURCE_GROUP \
--sku Basic \
--admin-enabled true

cd containers/acr/create-settings-xml

export ACR_USERNAME=`az acr credential show --name $ACR_NAME \
--resource-group $RESOURCE_GROUP --query username --output tsv`
export ACR_PASSWORD=`az acr credential show --name $ACR_NAME \
--resource-group $RESOURCE_GROUP --query 'passwords[0].value' --output tsv`
export SETTINGS_XML=$PWD/settings.xml

cd ../../..


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

cd compute/appservice/docker-jetty

export APPSERVICE_DOCKER_JETTY=appservice-docker-jetty-$RANDOM

mvn azure-webapp:deploy \
--settings=$SETTINGS_XML \
-DappName=$APPSERVICE_DOCKER_JETTY \
-DimageName=$ACR_JETTY_IMAGE \
-DappServicePlan=$APPSERVICE_PLAN \
-DresourceGroup=$RESOURCE_GROUP \
-DserverId=$ACR_NAME

az webapp show \
--resource-group $RESOURCE_GROUP \
--name $APPSERVICE_DOCKER_JETTY \
--query 'hostNames[0]' \
--output tsv

sleep 180
cd ../../..


export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_JETTY --output tsv --query state)
if [[ "$RESULT" != Running ]]; then
echo 'Web application is NOT running'
az group delete --name $RESOURCE_GROUP --yes || true
exit 1
fi

export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_JETTY --output tsv --query defaultHostName)
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"custom Jetty"* ]]; then
echo "Response did not contain 'custom Jetty'"
exit 1
fi