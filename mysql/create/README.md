
# Create an Azure Database for MySQL

[![mysql/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_create_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.cron(0 0 * * 2) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create the Azure Database for MySQL

To create the Azure Database for MySQL setup the following environment variables:

<!-- workflow.skip() -->
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

And then create the MySQL database using the command line below:

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

  export RESULT=$(az mysql server show --name $MYSQL_NAME --resource-group $RESOURCE_GROUP --output tsv --query userVisibleState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Ready ]]; then
    echo "Provisioning MySQL " $MYSQL_NAME " failed"
    exit 1
  fi

  -->

## Next steps

* [Open MySQL server firewall to your IP address](../open-firewall-to-your-ip/README.md)

## Reference documentation

* [Manage Azure Database for MySQL servers](https://docs.microsoft.com/cli/azure/mysql)
* [Azure Database for MySQL Documentation](https://docs.microsoft.com/azure/mysql/README.md)
* [Migrate to Azure Database for MySQL](https://datamigration.microsoft.com/scenario/mysql-to-azuremysql)
* [Minimal downtime migration](https://docs.microsoft.com/azure/mysql/howto-migrate-online)
* [Query data using Java](https://docs.microsoft.com/azure/mysql/connect-java)

4m
