
# Load your PostgreSQL database with data

[![postgresql/load-your-postgresql-database-with-data/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_load-your-postgresql-database-with-data_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_load-your-postgresql-database-with-data_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Database for PostgreSQL](../create/)
1. [Install curl](https://curl.haxx.se/download.html)
1. [Open PostgreSQL server firewall to your IP address](../open-firewall-to-your-ip/)
1. [Install psql client](https://www.postgresql.org/download/)

<!-- workflow.include(../open-firewall-to-your-ip/README.md) -->

## Load your PostgreSQL database with data

To load the PostgreSQL database with data execute the following command lines to
connect to the database:

<!-- workflow.skip() -->
```shell
  export POSTGRESQL_DNS_NAME=`az postgres server show \
    --resource-group $RESOURCE_GROUP \
    --name $POSTGRESQL_NAME \
    --query fullyQualifiedDomainName \
    --output tsv`

  export POSTGRESQL_CLIENT_USERNAME="$POSTGRESQL_USERNAME@$POSTGRESQL_NAME"

  psql --host=$POSTGRESQL_DNS_NAME --port=5432 --username $POSTGRESQL_CLIENT_USERNAME --password $POSTGRESQL_PASSWORD
```

Then use the following command line to load the `load.sql` file into the
database:

<!-- workflow.skip() -->
```shell
  \i load.sql;
```

And to exit the `psql` tool use the following command line:

<!-- workflow.skip() -->
```shell
  \q
```

>
> If your country is missing from the SQL file please let us know by filing a
> GitHub issue or by issuing a PR against this repository.
>

<!-- workflow.run()

  cd postgresql/load-your-postgresql-database-with-data

  export POSTGRESQL_DNS_NAME=`az postgres server show \
    --resource-group $RESOURCE_GROUP \
    --name $POSTGRESQL_NAME \
    --query fullyQualifiedDomainName \
    --output tsv`

  export POSTGRESQL_CLIENT_USERNAME="$POSTGRESQL_USERNAME@$POSTGRESQL_NAME"

  psql --host=$POSTGRESQL_DNS_NAME --port=5423 --username $POSTGRESQL_CLIENT_USERNAME --password $POSTGRESQL_PASSWORD --file load.sql

  cd ../..

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

