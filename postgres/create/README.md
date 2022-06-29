
# Create an Azure Database for PostgreSQL

[![postgres/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgres_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgres_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.cron(0 0 * * 1) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Database for PostgreSQL

To create the Azure Database for PostgreSQL setup the environment variables:

<!-- workflow.skip() -->
```shell

  export POSTGRESQL_NAME=postgresql-$RANDOM
  export POSTGRESQL_USERNAME=postgresql
  export POSTGRESQL_PASSWORD=p#ssw0rd-$RANDOM

```

<!-- workflow.run()

  if [[ -z $POSTGRESQL_NAME ]]; then
    export POSTGRESQL_NAME=postgresql-$RANDOM
    export POSTGRESQL_USERNAME=postgresql
    export POSTGRESQL_PASSWORD=p#ssw0rd-$RANDOM
  fi

  -->

```shell

  az postgres server create \
    --admin-user $POSTGRESQL_USERNAME \
    --admin-password $POSTGRESQL_PASSWORD \
    --name $POSTGRESQL_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku B_Gen5_1 \
    --ssl-enforcement Disabled

```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  export RESULT=$(az postgres server show --resource-group $RESOURCE_GROUP --name $POSTGRESQL_NAME --output tsv --query userVisibleState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Ready ]]; then
    echo 'PostgreSQL database is NOT ready'
    exit 1
  fi

  -->

3m
