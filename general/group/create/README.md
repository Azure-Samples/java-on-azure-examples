
# Create an Azure Resource Group

![group/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/group/create/README.md/badge.svg)

## Prerequisites

This example assume you are logged into Azure CLI and have set your default
subscription, if you have NOT done so please go to our top-level
[README](../../)

## Create the Resource Group

To setup the environment variables needed to create the Resource Group execute
the command lines below:

<!-- workflow.cron(0 1 * * 0) -->

<!-- workflow.skip() -->
```shell
  export RESOURCE_GROUP=java-on-azure
  export REGION=westus2
```

<!-- workflow.run()
if [[ -z $RESOURCE_GROUP ]]; then
  export RESOURCE_GROUP=java-on-azure-$RANDOM
fi
export REGION=westus2
  -->

To create the Resource Group use the following command line:

```shell
  az group create --name $RESOURCE_GROUP --location $REGION
```

<!-- workflow.run()
  export DELETE_AFTER=$(( `date +%s` + 7200))
  az group update --name $RESOURCE_GROUP --set tags.'DeleteAfter'="$DELETE_AFTER" 
  -->

<!-- workflow.directOnly()
export RESULT=$(az group show --name $RESOURCE_GROUP --output tsv --query properties.provisioningState)
az group delete --name $RESOURCE_GROUP --yes || true
if [[ "$RESULT" != Succeeded ]]; then
  exit 1
fi
  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

1. [Manage resource groups and template deployments](https://docs.microsoft.com/en-us/cli/azure/group)

1m
