
# Get country information (JDBC client)

[![sql/get-country/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/sql_get-country_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/sql_get-country_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure SQL Database](../create/README.md)
1. [Install curl](https://curl.haxx.se/download.html)
1. [Open Azure SQL server firewall to your IP address](../open-firewall-to-your-ip/README.md)
1. [Install mssql-cli client](https://docs.microsoft.com/en-us/sql/tools/mssql-cli?view=sql-server-ver15)
1. [Load your Azure SQL database with your data](../load-your-mssql-database-with-data/README.md)

<!-- workflow.cron(0 3 * * 3) -->
<!-- workflow.include(../load-your-mssql-database-with-data/README.md) -->

## Get country information

This example will get country information from the database.

<!-- workflow.run()

cd sql/get-country

  -->

First lets build the example.

```shell
  mvn package
```

The command line below will get the country information for the country with
the abbreviation 'USA'.

```shell
  java -jar target/get-country.jar "jdbc:sqlserver://$MSSQL_DNS_NAME:1433;databaseName=demo;encrypt=true;trustServerCertificate=true" $MSSQL_CLIENT_USERNAME $MSSQL_PASSWORD USA
```

<!-- workflow.run()

cd ../..

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->
