
# Create a self-signed certificate

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Key Vault](../create/)

## Create the self-signed certificate

Set the certificate alias environment variable

```shell
  export KEYVAULT_CERTIFICATE_ALIAS=self-signed
```

Create the self-signed certificate using alias 'self-signed'

```
  az keyvault certificate create --vault-name ${KEYVAULT_NAME} \
    --name ${KEYVAULT_CERTIFICATE_ALIAS} \
    --policy "$(az keyvault certificate get-default-policy)"
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
