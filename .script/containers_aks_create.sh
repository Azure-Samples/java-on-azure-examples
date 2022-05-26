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


export RESULT=$(az aks show --name $AKS --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
exit 1
fi