#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=westus2
fi

az group create --name $RESOURCE_GROUP --location $REGION
az upgrade --yes
az extension add --name containerapp --upgrade
az provider register --namespace Microsoft.App
az provider register --namespace Microsoft.OperationalInsights
if [[ -z $ACA_ENVIRONMENT_NAME ]]; then
export ACA_ENVIRONMENT_NAME=aca$RANDOM
export ACA_REGION=westus
fi
az containerapp env create \
--name $ACA_ENVIRONMENT_NAME \
--resource-group $RESOURCE_GROUP \
--location "$ACA_REGION"
sleep 60
export RESULT=$(az containerapp env show --name $ACA_ENVIRONMENT_NAME --resource-group $RESOURCE_GROUP --output tsv --query properties.provisioningState)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
echo "Azure Container Apps environment $ACA_ENVIRONMENT_NAME was not provisioned properly"
exit 1
fi