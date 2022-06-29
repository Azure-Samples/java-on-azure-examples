
# JDBC command line client

[![mysql/get-country/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_get-country_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_get-country_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Database for MySQL](../create/README.md)
1. [Install curl](https://curl.haxx.se/download.html)
1. [Open MySQL server firewall to your IP address](../open-firewall-to-your-ip/README.md)
1. [Install mysql client](https://dev.mysql.com/downloads/README.md)
1. [Load your MySQL database with your data](../load-your-mysqk-database-with-data/README.md)

<!-- workflow.cron(0 3 * * 2) -->
<!-- workflow.include(../load-your-mysql-database-with-data/README.md) -->

## JDBC command line client

This example will get country information from the database.

<!-- workflow.run()

cd mysql/get-country

  -->

First lets build the example.

```shell

  mvn package

```

The command line below will get the country information for the country with
the abbreviation 'USA'.

```shell

  java -jar target/get-country.jar jdbc:mysql://$MYSQL_DNS_NAME:3306/demo?useSSL=true\&requireSSL=true $MYSQL_CLIENT_USERNAME $MYSQL_PASSWORD USA

```

Note the & has been escaped using the backslash as this is needed when passing
it into the shell. Omit the backslash when using it in your configuration files.

<!-- workflow.run()

  cd ../..

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  cd mysql/get-country
  export RESULT=$(java -jar target/get-country.jar jdbc:mysql://$MYSQL_DNS_NAME:3306/demo?useSSL=true\&requireSSL=true $MYSQL_CLIENT_USERNAME $MYSQL_PASSWORD USA)
  cd ../..
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"United States"* ]]; then
    echo "Unable to get the correct country information"
    exit 1
  fi

  -->
