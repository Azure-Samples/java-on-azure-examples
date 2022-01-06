
# Adding a Secret to Azure Key Vault

[![security/keyvault/add-secret/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/security_keyvault_add-secret_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/security_keyvault_add-secret_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../groupd/create/README.md)
1. [Create an Azure Key Vault](../create/README.md)

<!-- workflow.cron(25 13 * * 5) -->
<!-- workflow.include(../../../general/group/create/README.md) -->
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
if [[ "$RESULT" != "mySecretValue" ]]; then
  echo 'Secret was not properly set'
  az group delete --name $RESOURCE_GROUP --yes || true
  exit 1
fi

az group delete --name $RESOURCE_GROUP --yes || true

  -->

## More information

1. [Azure CLI](https://docs.microsoft.com/cli/azure/keyvault/secret)
1. [Azure Key Vault Secrets - documentation](https://docs.microsoft.com/azure/key-vault/secrets)
