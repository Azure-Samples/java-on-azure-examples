#!/bin/bash
cd ..


if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION

if [[ -z $RESOURCE_GROUP ]]; then
export RESOURCE_GROUP=java-on-azure-$RANDOM
export REGION=southcentralus
fi

az group create --name $RESOURCE_GROUP --location $REGION
export EVENTHUBS_NAMESPACE=eventhubs-$RANDOM

az eventhubs namespace create \
--name $EVENTHUBS_NAMESPACE \
--resource-group $RESOURCE_GROUP \
--location $REGION
export EVENTHUBS_EVENTHUB=eventhubs-hub-$RANDOM

az eventhubs eventhub create \
--name $EVENTHUBS_EVENTHUB \
--resource-group $RESOURCE_GROUP \
--namespace-name $EVENTHUBS_NAMESPACE

export RESULT=$(az eventhubs eventhub show --name $EVENTHUBS_EVENTHUB --namespace-name $EVENTHUBS_NAMESPACE --resource-group $RESOURCE_GROUP --output tsv --query status)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Active ]]; then
echo "Azure Event Hubs EventHub - $EVENTHUBS_EVENTHUB - was not provisioned properly"
exit 1
fi