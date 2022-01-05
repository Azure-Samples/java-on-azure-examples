
# Get country information (JDBC client)

[![postgresql/get-country/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_get-country_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_get-country_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../../general/group/create/)
1. [Create an Azure Database for PostgreSQL](../create/)
1. [Install curl](https://curl.haxx.se/download.html)
1. [Open PostgreSQL server firewall to your IP address](../open-firewall-to-your-ip/)
1. [Install psql client](https://www.postgresql.org/download/)
1. [Load your PostgreSQL database with your data](load-your-postgresql-database-with-data/README.md)

<!-- workflow.include(../load-your-postgresql-database-with-data/README.md) -->

## Get country information

This example will get country information from the database.

<!-- workflow.run()

  cd postgresql/get-country

  -->

First lets build the example.

```shell
  mvn package
```

The command line below will get the country information for the country with
the abbreviation 'USA'.

```shell
  java -jar target/get-country.jar jdbc:postgresql://$POSTGRESQL_DNS_NAME:5432/demo?ssl=true\&sslmode=require $POSTGRESQL_CLIENT_USERNAME $POSTGRESQL_PASSWORD USA
```

Note the & has been escaped using the backslash as this is needed when passing
it into the shell. Omit the backslash when using it in your configuration files.

<!-- workflow.run()

  cd ../..

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->
