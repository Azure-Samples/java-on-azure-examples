
# Create a table

[![kusto/create-table/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/kusto_create-table_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/kusto_create-table_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create a resource group](../../group/create/README.md)
1. [Create an Azure Data Explorer cluster](../create/README.md)
1. [Create a database](../create-database/README.md)

## Create a table

<!-- workflow.include(../create-database/README.md) -->

Open up the Azure database explorer to start the process of creating a table.
To do so execute the following command line and use its output 

<!-- workflow.skip() -->
```shell
  echo https://dataexplorer.azure.com/clusters/$ADX_CLUSTER_NAME.$REGION/databases/$ADX_DATABASE_NAME
```

Then in the query window execute the following query.

```text
  .create table Events ( EventId:long, EventPayLoad:string )
```

This will create a simple table that stores the event date using a datetime and
the event payload as a string.

Then set the streaming ingestion policy for the table

```text
  .alter table Events policy streamingingestion enable
```

And then execute the following command line to set the environment variable:

```shell
  export ADX_TABLE=Events
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Data Explorer documentation](https://docs.microsoft.com/azure/data-explorer/README.md)
