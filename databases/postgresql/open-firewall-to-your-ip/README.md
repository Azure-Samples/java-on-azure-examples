
# Open PostgreSQL server firewall to your IP address

[![databases/postgresql/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/databases_postgresql_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/databases_postgresql_open-firewall-to-your-ip_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)
1. [Create an Azure Database for PostgreSQL](../create/README.md)
1. [Install curl](https://curl.haxx.se/download.html)

<!-- workflow.include(../create/README.md) -->

## Open PostgreSQL server firewall to your local IP address

To make it possible to communicate with your PostgreSQL server from your local IP
address execute the following command lines:

```shell
  export LOCAL_IP=`curl -s whatismyip.akamai.com`

  az postgres server firewall-rule create \
    --resource-group $RESOURCE_GROUP \
    --server $POSTGRESQL_NAME \
    --name AllowMyLocalIP \
    --start-ip-address $LOCAL_IP \
    --end-ip-address $LOCAL_IP
```

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources once you are done running the example.
