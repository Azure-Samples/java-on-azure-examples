
# Deploy an Azure Red Hat OpenShift cluster

[![aro/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aro_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aro_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

## Deploy an Azure Red Hat OpenShift cluster

<!-- workflow.include(../../group/create/README.md) -->

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

<!-- workflow.directOnly()

  export RESULT=$(az aro show --name $ARO_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure RedHat OpenShift cluster " $ARO_NAME " was not created successfully"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

* [Manage Azure Red Hat OpenShift clusters](https://docs.microsoft.com/cli/azure/aro)
* [Azure Red Hat OpenShift documentation](https://docs.microsoft.com/azure/openshift/)

38m
