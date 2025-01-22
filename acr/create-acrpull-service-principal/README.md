
# Create an 'acrpull' Service Principal

[![acr/create-acrpull-service-principal/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_create-acrpull-service-principal_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_create-acrpull-service-principal_README_md.yml)

## Prerequisites

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 1 * * 0) -->
<!-- workflow.include(../create/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../create/README.md)

## Create an 'acrpull' Service Principal

Execute the following command lines to create the 'acrpull' Service Principal:

<!-- workflow.skip() -->
```shell
  export ACR_PULL_SERVICE_PRINCIPAL_NAME=acr-pull-$RANDOM
  export ACR_ID=`az acr show --name $ACR_NAME --resource-group $RESOURCE_GROUP --query id --output tsv`
  export ACR_PULL_SERVICE_PRINCIPAL_PASSWORD=`az ad sp create-for-rbac \
    --name $ACR_PULL_SERVICE_PRINCIPAL_NAME \
    --scopes $ACR_ID \
    --role acrpull \
    --query password \
    --output tsv`
  export ACR_PULL_SERVICE_PRINCIPAL_ID=`az ad sp list \
    --display-name $ACR_PULL_SERVICE_PRINCIPAL_NAME \
    --query "[].appId" \
    --output tsv`
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
