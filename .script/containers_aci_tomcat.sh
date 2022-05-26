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

if [[ -z $ACR_PULL_SERVICE_PRINCIPAL_NAME ]]; then
export ACR_PULL_SERVICE_PRINCIPAL_NAME=acr-pull-$RANDOM
export ACR_ID=`az acr show --name $ACR_NAME --query id --output tsv`
export ACR_PULL_SERVICE_PRINCIPAL_PASSWORD=`az ad sp create-for-rbac \
--name $ACR_PULL_SERVICE_PRINCIPAL_NAME \
--scopes $ACR_ID \
--role acrpull \
--query password \
--output tsv`
export ACR_PULL_SERVICE_PRINCIPAL_ID=`az ad sp list \
--display-name $ACR_PULL_SERVICE_PRINCIPAL_NAME \
--query [].appId \
--output tsv`
fi


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

cd containers/acr/tomcat

mvn package
export ACR_TOMCAT_IMAGE=tomcat:latest

az acr build --registry $ACR_NAME --image $ACR_TOMCAT_IMAGE .

cd ../../..

export ACI_TOMCAT=aci-tomcat-$RANDOM

az container create \
--resource-group $RESOURCE_GROUP \
--name $ACI_TOMCAT \
--image $ACR_NAME.azurecr.io/$ACR_TOMCAT_IMAGE \
--registry-login-server $ACR_NAME.azurecr.io \
--registry-username $ACR_PULL_SERVICE_PRINCIPAL_ID \
--registry-password $ACR_PULL_SERVICE_PRINCIPAL_PASSWORD \
--dns-name-label $ACI_TOMCAT \
--ports 8080

echo `az container show \
--resource-group $RESOURCE_GROUP \
--name $ACI_TOMCAT \
--query ipAddress.fqdn \
--output tsv`:8080

export URL=http://$(az container show --resource-group $RESOURCE_GROUP --name $ACI_TOMCAT --query ipAddress.fqdn --output tsv):8080
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"custom Tomcat"* ]]; then
echo "Response did not contain 'custom Tomcat'"
exit 1
fi