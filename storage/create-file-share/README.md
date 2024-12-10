# Create an Azure File Share

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_create-file-share_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_create-file-share_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
2. [Create an Azure Storage Account](../create/README.md)

<!-- workflow.cron(0 10 * * 0) -->
<!-- workflow.include(../create/README.md) -->

## Create the Azure File Share

To create the Azure File Share use the following command lines:

```shell
  export STORAGE_SHARE_NAME=joazshare$RANDOM

  az storage share create --name $STORAGE_SHARE_NAME --account-name $STORAGE_ACCOUNT_NAME

```

## Cleanup

<!-- workflow.directOnly() 

  export RESULT=$(az storage share show --account-name $STORAGE_ACCOUNT_NAME --name $STORAGE_SHARE_NAME --query lease.state --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != available ]]; then
    exit 1
  fi  

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
