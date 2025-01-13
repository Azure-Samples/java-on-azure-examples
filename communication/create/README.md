
# Create an Azure Communication Service

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)


## Create an Azure Communication Service

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 0 * * 0) -->
<!-- workflow.include(../../group/create/README.md) -->


To create an Azure Communication Service use the following command lines:

```shell
  export AZURE_COMMUNICATION_NAME=joazcom-$RANDOM
  export AZURE_COMMUNICATION_LOCATION=global

  az config set extension.use_dynamic_install=yes_without_prompt
  az communication create --name $AZURE_COMMUNICATION_NAME --resource-group $RESOURCE_GROUP --location $AZURE_COMMUNICATION_LOCATION --data-location UnitedStates
```

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az communication show --name $AZURE_COMMUNICATION_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Communication Service '" $AZURE_COMMUNICATION_NAME "' was not created successfully"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

1m
