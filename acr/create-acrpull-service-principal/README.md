
# Create an 'acrpull' Service Principal

[![acr/create-acrpull-service-principal/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_create-acrpull-service-principal_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_create-acrpull-service-principal_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../create/README.md)

<!-- workflow.cron(0 1 * * 0) -->
<!-- workflow.include(../create/README.md) -->

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
    --query [].appId \
    --output tsv`
fi
```

<!-- workflow.run()

  if [[ -z $ACR_PULL_SERVICE_PRINCIPAL_NAME ]]; then
    export ACR_PULL_SERVICE_PRINCIPAL_NAME=acr-pull-$RANDOM
    export ACR_ID=`az acr show --name $ACR_NAME --query id --output tsv`
    export ACR_PULL_SERVICE_PRINCIPAL_PASSWORD=`az ad sp create-for-rbac \
      --name $ACR_PULL_SERVICE_PRINCIPAL_NAME \
      --scopes $ACR_ID \
      --role acrpull \
      --query password \
      --output tsv`
    export ACR_PULL_SERVICE_PRINCIPAL_ID=`az ad sp list \
      --display-name $ACR_PULL_SERVICE_PRINCIPAL_NAME \
      --query [].appId \
      --output tsv`
  fi

  -->

<!-- workflow.directOnly() 

  az group delete --name $RESOURCE_GROUP --yes || true
  az ad sp delete --id $ACR_PULL_SERVICE_PRINCIPAL_ID || true

  if [[ -z $ACR_PULL_SERVICE_PRINCIPAL_PASSWORD ]]; then
    echo "ACR 'acrpull' service principal password was not found"
    exit 1
  fi

  if [[ -z $ACR_PULL_SERVICE_PRINCIPAL_ID ]]; then
    echo "ACR 'acrpull' service principal id was not found"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
