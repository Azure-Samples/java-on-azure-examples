
# Create an Azure SQL Database

[![sql/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/sql_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/sql_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.cron(0 0 * * 3) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure SQL Database

To create the Azure SQL Database setup the environment variables:

<!--workflow.skip() -->
```shell
  export MSSQL_NAME=mssql-$RANDOM
  export MSSQL_USERNAME=mssql
  export MSSQL_PASSWORD=p#ssw0rd-$RANDOM
```

<!-- workflow.run()
if [[ -z $MSSQL_NAME ]]; then
  export MSSQL_NAME=mssql-$RANDOM
  export MSSQL_USERNAME=mssql
  export MSSQL_PASSWORD=p#ssw0rd-$RANDOM
fi
  -->

```shell
  az sql server create \
    --admin-user $MSSQL_USERNAME \
    --admin-password $MSSQL_PASSWORD \
    --name $MSSQL_NAME \
    --resource-group $RESOURCE_GROUP
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

4m
