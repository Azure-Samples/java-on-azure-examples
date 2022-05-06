#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
fi

az group create --name $RESOURCE_GROUP --location $REGION

if [[ -z $AKS ]]; then
export AKS=aks-$RANDOM
az aks create --name $AKS --resource-group $RESOURCE_GROUP --generate-ssh-keys --verbose
fi


cd containers/aks/create-kube-config

az aks get-credentials --resource-group $RESOURCE_GROUP --name $AKS --admin --file config
export KUBECONFIG=$PWD/config

cd ../../..


az group delete --name $RESOURCE_GROUP --yes || true
if [[ ! -f $KUBECONFIG ]]; then
exit 1
fi