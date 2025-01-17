
# SQL Database JDBC CLI

[![sql/get-country/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/sql_get-country_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/sql_get-country_README_md.yml)

## Prerequisites

<!-- workflow.cron(0 6 * * 1) -->
<!-- workflow.include(../open-firewall-to-your-ip/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure SQL Database](../create/README.md)
1. [Install curl](https://curl.haxx.se/download.html)
1. [Open Azure SQL server firewall to your IP address](../open-firewall-to-your-ip/README.md)

## SQL Database JDBC CLI

This example will send a SQL statement to the database.

<!-- workflow.run()

cd sql/cli

  -->

First lets build the example.

```shell
  mvn package
```

Setup the correct environment variables.

```shell
export MSSQL_DNS_NAME=`az sql server show \
    --resource-group $RESOURCE_GROUP \
    --name $MSSQL_NAME \
    --query fullyQualifiedDomainName \
    --output tsv`

  export MSSQL_CLIENT_USERNAME="$MSSQL_USERNAME@$MSSQL_NAME"
```

The command line below will send the "SELECT 1" statement to the database.

```shell
  java -jar target/cli.jar "jdbc:sqlserver://$MSSQL_DNS_NAME:1433;encrypt=true;trustServerCertificate=true" $MSSQL_CLIENT_USERNAME $MSSQL_PASSWORD "SELECT 1"
```

<!-- workflow.run()

cd ../..

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->
