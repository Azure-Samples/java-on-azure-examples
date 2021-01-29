
# Deploy an Azure Red Hat OpenShift cluster

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create an Azure Resource Group](../../group/create/)

## Deploy an Azure Red hat OpenShift cluster

To deploy the Azure Red hat OpenShift cluster use the following command lines:

```shell
  export ARO_NAME=aro-$RANDOM

  az network vnet create \
    --resource-group $RESOURCE_GROUP \
    --name aro-vnet \
    --address-prefixes 10.0.0.0/22

  az network vnet subnet create \
    --resource-group $RESOURCE_GROUP \
    --vnet-name aro-vnet \
    --name aro-master-subnet \
    --address-prefixes 10.0.0.0/23 \
    --service-endpoints Microsoft.ContainerRegistry 

  az network vnet subnet create \
    --resource-group $RESOURCE_GROUP \
    --vnet-name aro-vnet \
    --name aro-worker-subnet \
    --address-prefixes 10.0.2.0/23 \
    --service-endpoints Microsoft.ContainerRegistry

  az network vnet subnet update \
    --name aro-master-subnet \
    --resource-group $RESOURCE_GROUP \
    --vnet-name aro-vnet \
    --disable-private-link-service-network-policies true

  az aro create \
    --name $ARO_NAME \
    --resource-group $RESOURCE_GROUP \
    --master-subnet aro-master-subnet \
    --worker-subnet aro-worker-subnet \
    --vnet aro-vnet
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
