
# Open Azure SQL server firewall to your IP address

[![mssql/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_open-firewall-to-your-ip_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure SQL Database](../create/)
1. [Install curl](https://curl.haxx.se/download.html)

<!-- workflow.cron(0 4 * * 5) -->
<!-- workflow.include(../create/README.md) -->

## Open Azure SQL server firewall to your local IP address

To make it possible to communicate with your SQL server from your local IP
address execute the following command lines:

```shell
  export LOCAL_IP=`curl -s whatismyip.akamai.com`

  az sql server firewall-rule create \
    --resource-group $RESOURCE_GROUP \
    --server $MSSQL_NAME \
    --name AllowMyLocalIP \
    --start-ip-address $LOCAL_IP \
    --end-ip-address $LOCAL_IP
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
