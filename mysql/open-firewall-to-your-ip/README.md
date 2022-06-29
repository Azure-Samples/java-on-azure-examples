
# Open MySQL server firewall to your IP address

[![mysql/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_open-firewall-to-your-ip_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Database for MySQL](../create/README.md)
1. [Install curl](https://curl.haxx.se/download.html)

<!-- workflow.cron(0 1 * * 2) -->
<!-- workflow.include(../create/README.md) -->

## Open MySQL server firewall to your local IP address

To make it possible to communicate with your MySQL server from your local IP
address execute the following command lines:

```shell
  export LOCAL_IP=`curl -s whatismyip.akamai.com`

  az mysql server firewall-rule create \
    --resource-group $RESOURCE_GROUP \
    --server $MYSQL_NAME \
    --name AllowMyLocalIP \
    --start-ip-address $LOCAL_IP \
    --end-ip-address $LOCAL_IP
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

<!-- workflow.directOnly()

  export RESULT=$(az mysql server firewall-rule show --resource-group $RESOURCE_GROUP --server $MYSQL_NAME --name AllowMyLocalIP --query name --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != AllowMyLocalIP ]]; then
    echo "MySQL firewall was NOT configured to allow access from " $LOCAL_IP
    exit 1
  fi

  -->

## Next steps

* [Azure Database for MySQL Documentation](https://docs.microsoft.com/en-us/azure/mysql/README.md)
* [Migrate to Azure Database for MySQL](https://datamigration.microsoft.com/scenario/mysql-to-azuremysql)
* [Minimal downtime migration](https://docs.microsoft.com/en-us/azure/mysql/howto-migrate-online)
* [Query data using Java](https://docs.microsoft.com/en-us/azure/mysql/connect-java)
* [Manage Azure Database for MySQL servers](https://docs.microsoft.com/cli/azure/mysql)

1m
