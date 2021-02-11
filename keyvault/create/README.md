
# Create an Azure Key Vault

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

## Create the Azure Key Vault

To create the Azure Key Vault use the following command lines:

```shell
  KEYVAULT_NAME="keyvault-$RANDOM"

  az keyvault create \
    --resource-group $RESOURCE_GROUP \
    --name $KEYVAULT_NAME
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Reference material

1. [Azure CLI](https://docs.microsoft.com/cli/azure/keyvault)
1. [Azure Key Vault - documentation](https://docs.microsoft.com/azure/key-vault/)
