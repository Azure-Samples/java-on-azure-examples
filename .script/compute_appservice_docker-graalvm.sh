#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
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

cd containers/acr/graalvm

mvn package
docker build -t builder -f Dockerfile.builder .
docker run --rm --tty -v $PWD/../../..:/mnt builder mvn -P graalvm -pl containers/acr/graalvm clean install
export ACR_GRAALVM_IMAGE=graalvm:latest

az acr build --registry $ACR_NAME --image $ACR_GRAALVM_IMAGE .

cd ../../..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
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

cd compute/appservice/docker-graalvm

export APPSERVICE_DOCKER_GRAALVM=appservice-docker-graalvm-$RANDOM

mvn azure-webapp:deploy \
--settings=$SETTINGS_XML \
-DappName=$APPSERVICE_DOCKER_GRAALVM \
-DimageName=$ACR_GRAALVM_IMAGE \
-DappServicePlan=$APPSERVICE_PLAN \
-DresourceGroup=$RESOURCE_GROUP \
-DserverId=$ACR_NAME

echo `az webapp show \
--resource-group $RESOURCE_GROUP \
--name $APPSERVICE_DOCKER_GRAALVM \
--query 'hostNames[0]' \
--output tsv`/hello

sleep 180
cd ../../..


export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_GRAALVM --output tsv --query state)
if [[ "$RESULT" != Running ]]; then
echo 'Web application is NOT running'
az group delete --name $RESOURCE_GROUP --yes || true
exit 1
fi

export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_DOCKER_GRAALVM --output tsv --query defaultHostName)/hello
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"Hello"* ]]; then
echo "Response did not contain 'Hello'"
exit 1
fi