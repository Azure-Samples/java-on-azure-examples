# List files in an Azure File Share

[![README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_list-file-share_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_list-file-share_README_md.yml)

## Prerequisites

<!-- workflow.cron(0 15 * * 0) -->
<!-- workflow.include(../create-file-share/README.md) -->

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
2. [Create an Azure Storage Account](../create/README.md)
3. [Create an Azure File Share](../create-file-share/README.md)

<!-- workflow.run()

  cd storage/list-file-share 

  -->

## Compile the example

To compile the example, navigate to the directory containing the `pom.xml` file and run the following command:

```
  mvn -ntp install
```

## List the files in the Azure File Share

To list the files, use the following command:

```
  java -jar target/list-file-share.jar
```

## Cleanup

<!-- workflow.directOnly() 

  export RESULT=$(java -jar target/list-file-share.jar)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *""* ]]; then
    echo "There are already files in your Azure File Share"
    exit 1
  fi

  cd ../..

  -->

Do NOT forget to remove the resources once you are done running the example.

1m
