
# Create a table

## Prerequisites

This example assumes you have previously completed the following example.

1. [Create a resource group](../../group/create/README.md)
1. [Create an Azure Data Explorer cluster](../create/README.md)
1. [Create a Database](../create-database/README.md)

## Create a table

<!-- workflow.include(../create/create-database.md) -->

Open up the Azure database explorer to start the process of creating a table.
To do so execute the following command line and use its output 

<!-- workflow.skip() -->
```shell
  echo https://dataexplorer.azure.com/clusters/$ADX_NAME.$REGION/databases/$ADX_DATABASE
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

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Additional documentation

1. [Azure Data Explorer documentation](https://docs.microsoft.com/azure/data-explorer/)
