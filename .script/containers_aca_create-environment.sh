#!/bin/bash
cd ..

az upgrade
az extension add --name containerapp --upgrade
az provider register --namespace Microsoft.App
az provider register --namespace Microsoft.OperationalInsights
if [[ -z $ACA_ENVIRONMENT ]]; then
export ACA_ENVIRONMENT=aca$RANDOM
fi
az containerapp env create \
--name $ACA_ENVIRONMENT_NAME \
--resource-group $RESOURCE_GROUP \
--location "$ACA_REGION"
export RESULT=$(az containerapp env show --name $ACA_ENVIRONMENT_NAME --resource-group $RESOURCE_GROUP --output tsv --query properties.provisioningState)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
echo "Azure Container Apps environment $ACA_ENVIRONMENT_NAME was not provisioned properly"
exit 1
fi