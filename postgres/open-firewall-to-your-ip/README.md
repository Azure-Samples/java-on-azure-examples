
# Open PostgreSQL server firewall to your IP address

[![postgres/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgres_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgres_open-firewall-to-your-ip_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Database for PostgreSQL](../create/README.md)
1. [Install curl](https://curl.haxx.se/download.html)

<!-- workflow.cron(0 1 * * 1) -->
<!-- workflow.include(../create/README.md) -->

## Open PostgreSQL server firewall to your local IP address

To make it possible to communicate with your PostgreSQL server from your local IP
address execute the following command lines:

```shell
  export LOCAL_IP=`curl -s whatismyip.akamai.com`

  az postgres server firewall-rule create \
    --resource-group $RESOURCE_GROUP \
    --server-name $POSTGRESQL_NAME \
    --name AllowMyLocalIP \
    --start-ip-address $LOCAL_IP \
    --end-ip-address $LOCAL_IP
```

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az postgres server firewall-rule show --resource-group $RESOURCE_GROUP --server-name $POSTGRESQL_NAME --name AllowMyLocalIP --query name --output tsv)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != AllowMyLocalIP ]]; then
    echo "PostgreSQL firewall was NOT configured to allow access from " $LOCAL_IP
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
