
# Create an Azure Database for MySQL

[![mysql/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/)

<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Database for MySQL

To create the Azure Database for MySQL setup the environment variables:

<!--workflow.skip() -->
```shell
  export MYSQL_NAME=mysql-$RANDOM
  export MYSQL_USERNAME=mysql
  export MYSQL_PASSWORD=p#ssw0rd-$RANDOM
```

<!-- workflow.run()
if [[ -z $MYSQL_NAME ]]; then
  export MYSQL_NAME=mysql-$RANDOM
  export MYSQL_USERNAME=mysql
  export MYSQL_PASSWORD=p#ssw0rd-$RANDOM
fi
  -->

```shell
  az mysql server create \
    --admin-user $MYSQL_USERNAME \
    --admin-password $MYSQL_PASSWORD \
    --name $MYSQL_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku B_Gen5_1 \
    --ssl-enforcement Disabled
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

## Next steps

* [Azure Database for MySQL Documentation](https://docs.microsoft.com/en-us/azure/mysql/)
* [Migrate to Azure Database for MySQL](https://datamigration.microsoft.com/scenario/mysql-to-azuremysql)
* [Minimal downtime migration](https://docs.microsoft.com/en-us/azure/mysql/howto-migrate-online)
* [Query data using Java](https://docs.microsoft.com/en-us/azure/mysql/connect-java)
* [Manage Azure Database for MySQL servers](https://docs.microsoft.com/en-us/cli/azure/mysql)

4m
