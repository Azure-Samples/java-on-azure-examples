
# Create a self-signed certificate

[![security/keyvault/create-self-signed-certificate/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/security_keyvault_create-self-signed-certificate_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/security_keyvault_create-self-signed-certificate_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)
1. [Create an Azure Key Vault](../create/README.md)

<!-- workflow.cron(23 16 * * 1) -->
<!-- workflow.include(../create/README.md) -->

## Create the self-signed certificate

Execute the command line below to set the certificate alias environment variable

```shell
  export KEYVAULT_CERTIFICATE_ALIAS=self-signed
```

Create the self-signed certificate using alias 'self-signed' by executing the
command line below.

```shell
  az keyvault certificate create --vault-name $KEYVAULT_NAME \
    --name $KEYVAULT_CERTIFICATE_ALIAS \
    --policy "$(az keyvault certificate get-default-policy)"
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  sleep 60
  export RESULT=$(az keyvault certificate show --vault-name $KEYVAULT_NAME --name $KEYVAULT_CERTIFICATE_ALIAS --output tsv --query attributes.enabled)
  if [[ "$RESULT" != true ]]; then
    echo 'Certificate was not provisioned'
    az group delete --name $RESOURCE_GROUP --yes || true
    exit 1
  fi

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

## Reference material

1. [Azure CLI](https://docs.microsoft.com/cli/azure/keyvault/certificate)
1. [Azure Key Vault - Cerificates documentation](https://docs.microsoft.com/azure/key-vault/certificates/README.md)
