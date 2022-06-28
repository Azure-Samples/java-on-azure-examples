
# Adding a Secret to Azure Key Vault

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/keyvault_add-secret_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/keyvault_add-secret_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Key Vault](../create/README.md)

<!-- workflow.cron(0 1 * * 2) -->
<!-- workflow.include(../create/README.md) -->

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

<!-- workflow.directOnly()

  export RESULT=$(az keyvault secret show --name mySecret --vault $KEYVAULT_NAME --query value --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != "mySecretValue" ]]; then
    echo 'Secret was not properly set'
    exit 1
  fi

  -->

## More information

1. [Azure CLI](https://docs.microsoft.com/cli/azure/keyvault/secret)
1. [Azure Key Vault Secrets - documentation](https://docs.microsoft.com/azure/key-vault/secrets)
