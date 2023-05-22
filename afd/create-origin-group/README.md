
# Create an Azure Front Door Origin Group

[![afd/create-origin-group/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_create-origin-group_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_create-origin-group_README_md.yml)

## Prerequisites

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus3
    echo "Using 'westus3' region"
  fi

  -->
<!-- workflow.cron(0 2 * * 1) -->
<!-- workflow.include(../create-endpoint/README.md) -->

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Front Door Profile](../create-profile/README.md)
1. [Create an Azure Front Door Endpoint](../create-endpoint/README.md)

## Create an Azure Front Door Origin Group

Setup environment variable for the Azure Front Door Origin Group using the command
line below:

<!-- workflow.skip() -->
```shell
  export AFD_ORIGIN_GROUP_NAME=afdorigrp$RANDOM
```

<!-- workflow.run()

if [[ -z $AFD_ORIGIN_GROUP_NAME ]]; then
  export AFD_ORIGIN_GROUP_NAME=afdorigrp$RANDOM
fi
  -->

To create the Azure Front Door Endpoint use the following command line:

```shell
  az afd origin-group create \
    --resource-group $RESOURCE_GROUP \
    --origin-group-name $AFD_ORIGIN_GROUP_NAME \
    --profile-name $AFD_PROFILE_NAME \
    --probe-request-type GET \
    --probe-protocol Http \
    --probe-interval-in-seconds 60 \
    --probe-path / \
    --sample-size 4 \
    --successful-samples-required 3 \
    --additional-latency-in-milliseconds 50
```

<!-- workflow.directOnly()

  export RESULT=$(az afd origin-group show --origin-group-name $AFD_ORIGIN_GROUP_NAME --profile-name $AFD_PROFILE_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Front Door Origin Group $AFD_ORIGIN_GROUP_NAME was not provisioned properly"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
