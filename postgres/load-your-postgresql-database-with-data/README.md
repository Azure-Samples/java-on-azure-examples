
# Load your PostgreSQL database with data

[![postgres/load-your-postgresql-database-with-data/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgres_load-your-postgresql-database-with-data_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgres_load-your-postgresql-database-with-data_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Database for PostgreSQL](../create/README.md)
1. [Install curl](https://curl.haxx.se/download.html)
1. [Open PostgreSQL server firewall to your IP address](../open-firewall-to-your-ip/README.md)
1. [Install psql client](https://www.postgresql.org/download/README.md)

<!-- workflow.cron(0 2 * * 1) -->
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

  psql --host=$POSTGRESQL_DNS_NAME --port=5432 --username $POSTGRESQL_CLIENT_USERNAME --dbname=postgres
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

  cd postgres/load-your-postgresql-database-with-data

  export POSTGRESQL_DNS_NAME=`az postgres server show \
    --resource-group $RESOURCE_GROUP \
    --name $POSTGRESQL_NAME \
    --query fullyQualifiedDomainName \
    --output tsv`

  export POSTGRESQL_CLIENT_USERNAME="$POSTGRESQL_USERNAME@$POSTGRESQL_NAME"

  PGPASSWORD=$POSTGRESQL_PASSWORD psql --host=$POSTGRESQL_DNS_NAME --port=5432 --username $POSTGRESQL_CLIENT_USERNAME --dbname=postgres --file load.sql

  cd ../..

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  echo 'SELECT COUNT(*) FROM countries;' > check.sql
  export RESULT=$(PGPASSWORD=$POSTGRESQL_PASSWORD psql --host=$POSTGRESQL_DNS_NAME -qtAX --port=5432 --username $POSTGRESQL_CLIENT_USERNAME --dbname=demo --csv < check.sql)
  if [[ "$RESULT" != "1" ]]; then
    echo "PostgreSQL data was NOT loaded"
    exit 1
  fi
  az group delete --name $RESOURCE_GROUP --yes || true

  -->

1m
