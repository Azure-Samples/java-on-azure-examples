
# Create an Azure Container Registry

[![acr/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

## Create an Azure Container Registry

Setup environment variable for the Azure Container Registry using the command
line below:

<!-- workflow.cron(0 0 * * 0) -->
<!-- workflow.include(../../group/create/README.md) -->

<!-- workflow.skip() -->
```shell
  export ACR_NAME=acreg$RANDOM
```

<!-- workflow.run()
if [[ -z $ACR_NAME ]]; then
  export ACR_NAME=acreg$RANDOM
fi
  -->

To create the Azure Container Registry use the following command line:

```shell
  az acr create \
    --name $ACR_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku Basic \
    --admin-enabled true
```

<!-- workflow.directOnly()

  export RESULT=$(az acr show --name $ACR_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Container Registry $ACR_NAME was not provisioned properly"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
