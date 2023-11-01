
# Open Azure SQL server firewall to your IP address

[![sql/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/sql_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/sql_open-firewall-to-your-ip_README_md.yml)

## Prerequisites

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus2
  fi

  -->
<!-- workflow.cron(0 23 * * 4) -->
<!-- workflow.include(../create/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure SQL Database](../create/README.md)
1. [Install curl](https://curl.haxx.se/download.html)

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
