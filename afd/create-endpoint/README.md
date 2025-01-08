
# Create an Azure Front Door Endpoint

[![afd/create-endpoint/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_create-endpoint_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_create-endpoint_README_md.yml)

## Prerequisites

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 1 * * 1) -->
<!-- workflow.include(../create-profile/README.md) -->

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Front Door Profile](../create-profile/README.md)

## Create an Azure Front Door Endpoint

Setup environment variable for the Azure Front Door Endpoint using the command
line below:

<!-- workflow.skip() -->
```shell
  export AFD_ENDPOINT_NAME=javazafdendp$RANDOM
```

<!-- workflow.run()

if [[ -z $AFD_ENDPOINT_NAME ]]; then
  export AFD_ENDPOINT_NAME=javazafdendp$RANDOM
fi
  -->

To create the Azure Front Door Endpoint use the following command line:

```shell
  az afd endpoint create \
    --resource-group $RESOURCE_GROUP \
    --endpoint-name $AFD_ENDPOINT_NAME \
    --profile-name $AFD_PROFILE_NAME \
    --enabled-state Enabled
```

<!-- workflow.directOnly()

  export RESULT=$(az afd endpoint show --endpoint-name $AFD_ENDPOINT_NAME --profile-name $AFD_PROFILE_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Front Door Endpoint $AFD_ENDPOINT_NAME was not provisioned properly"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
