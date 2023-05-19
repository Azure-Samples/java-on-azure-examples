
# Create an Azure Front Door Profile

[![afd/create-profile/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_create-profile_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_create-profile_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 1 * * 1) -->
<!-- workflow.include(../../group/create/README.md) -->

## Create an Azure Front Door Profile

Setup environment variable for the Azure Front Door Profile using the command
line below:

<!-- workflow.skip() -->
```shell
  export AFD_PROFILE_NAME=jazafd$RANDOM
```

<!-- workflow.run()

if [[ -z $AFD_PROFILE_NAME ]]; then
  export AFD_PROFILE_NAME=jazafd$RANDOM
fi
  -->

To create the Azure Front Door Profile use the following command line:

```shell
  az afd profile create \
    --profile-name $AFD_PROFILE_NAME \
    --resource-group $RESOURCE_GROUP \
    --sku Premium_AzureFrontDoor
```

<!-- workflow.directOnly()

  export RESULT=$(az afd profile show --profile-name $AFD_PROFILE_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Front Door Profile $AFD_PROFILE_NAME was not provisioned properly"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
