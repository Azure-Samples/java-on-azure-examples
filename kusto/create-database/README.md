
# Create a database

[![kusto/create-database/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/kusto_create-database_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/kusto_create-database_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create a resource group](../../group/create/README.md)
1. [Create an Azure Data Explorer cluster](../create/README.md)

## Create a database

<!-- workflow.cron(0 1 * * 0) -->
<!-- workflow.include(../create/README.md) -->

Setup the environment variable for the database using the command
line below:

<!-- workflow.skip() -->
```shell
  export ADX_DATABASE_NAME=adxdb$RANDOM
```

To create the database use the following command line:

<!-- workflow.skip() -->
```shell
  az kusto database create \
    --cluster-name $ADX_CLUSTER_NAME \
    --resource-group $RESOURCE_GROUP \
    --database-name $ADX_DATABASE_NAME \
    --read-write-database location="$REGION"
```

<!-- workflow.run() 

  if [[ -z $ADX_DATABASE_NAME ]]; then
    export ADX_DATABASE_NAME=adxdb$RANDOM
    az kusto database create \
      --cluster-name $ADX_CLUSTER_NAME \
      --resource-group "$RESOURCE_GROUP" \
      --database-name "$ADX_DATABASE_NAME" \
      --read-write-database location="$REGION"
  fi

  -->

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az kusto database show --cluster-name $ADX_CLUSTER_NAME \
    --database-name $ADX_DATABASE_NAME --resource-group $RESOURCE_GROUP \
    --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Failed to create ADX database $ADX_DATABASE_NAME"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Data Explorer documentation](https://docs.microsoft.com/azure/data-explorer/README.md)
1. [Azure CLI - az kusto database](https://docs.microsoft.com/cli/azure/kusto/database)

1m
