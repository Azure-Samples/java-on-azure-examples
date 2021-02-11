
# Adding a Secret to Azure Key Vault

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../groupd/create/)
1. [Create an Azure Key Vault](../create/)

## Add a Secret to Azure Key Vault

To add a Secret to the Azure Key Vault use the command line below:

```shell
  az keyvault secret set \
    --name mySecret \
    --value mySecretValue \
    --vault-name $KEYVAULT_NAME
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Reference material

1. [Azure CLI](https://docs.microsoft.com/cli/azure/keyvault/secret)
1. [Azure Key Vault Secrets - documentation](https://docs.microsoft.com/azure/key-vault/secrets)
