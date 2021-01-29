
# Create an Azure Database for MySQL

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

## Create the Azure Database for MySQL

To create the Azure Database for MySQL use the following command lines:

````shell
  export MYSQL_NAME=mysql-$RANDOM
  export MYSQL_USERNAME=mysql
  export MYSQL_PASSWORD=p#ssw0rd-$RANDOM

  az mysql server create \
    --admin-user $MYSQL_USERNAME \
    --admin-password $MYSQL_PASSWORD \
    --name $MYSQL_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku B_Gen5_1 \
    --ssl-enforcement Disabled
````

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Azure Database for MySQL Documentation](https://docs.microsoft.com/en-us/azure/mysql/)
* [Migrate to Azure Database for MySQL](https://datamigration.microsoft.com/scenario/mysql-to-azuremysql)
* [Minimal downtime migration](https://docs.microsoft.com/en-us/azure/mysql/howto-migrate-online)
* [Query data using Java](https://docs.microsoft.com/en-us/azure/mysql/connect-java)
* [Manage Azure Database for MySQL servers](https://docs.microsoft.com/en-us/cli/azure/mysql)

4m
