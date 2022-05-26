#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION

if [[ -z $AKS ]]; then
export AKS=aks-$RANDOM
az aks create --name $AKS --resource-group $RESOURCE_GROUP --generate-ssh-keys --verbose
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
az aks update --name $AKS --resource-group $RESOURCE_GROUP --attach-acr $ACR_NAME

az group delete --name $RESOURCE_GROUP --yes || true