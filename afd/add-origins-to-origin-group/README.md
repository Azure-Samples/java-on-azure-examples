
# Add origins to an Azure Front Door Origin Group

[![afd/add-origins-to-origin-group/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_add-origins-to-origin-group_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_add-origins-to-origin-group_README_md.yml)

## Prerequisites

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 3 * * 5) -->
<!-- workflow.include(../create-origin-group/README.md) -->
<!-- workflow.include(../../appservice/javase-springboot/README.md) -->
<!-- workflow.include(../../appservice/javase-quarkus/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Front Door Profile](../create-profile/README.md)
1. [Create an Azure Front Door Endpoint](../create-endpoint/README.md)
1. [Create an Azure Front Door Origin Group](../create-origin-group/README.md)
1. [Create an Azure App Service Plan](../../appservice/create-plan/README.md)
1. [Deploy a managed JavaSE Spring Boot application](../../appservice/javase-springboot/README.md)
1. [Deploy a managed JavaSE Quarkus application](../../appservice/javase-quarkus/README.md)

## Add origins to an Azure Front Door Origin Group

We need to get the hostname for the primary application, which is the Spring Boot application
we deployed previously. Use the following command line to set the required environment variable:

```shell
  export AFD_PRIMARY_HOST_NAME=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_JAVASE_SPRINGBOOT --output tsv --query defaultHostName)
```

Next we need to add the primary application as an origin to the origin group. Use the commandline below:

```shell
  az afd origin create \
    --resource-group $RESOURCE_GROUP \
    --host-name $AFD_PRIMARY_HOST_NAME \
    --profile-name $AFD_PROFILE_NAME \
    --origin-group-name $AFD_ORIGIN_GROUP_NAME \
    --origin-name springboot \
    --origin-host-header $AFD_PRIMARY_HOST_NAME \
    --priority 1 \
    --weight 1000 \
    --enabled-state Enabled \
    --http-port 80 \
    --https-port 443
```

The next step is to get the hostname for the secondary application, which is the Quarkus application
we deployed previously. Use the following command line to set the required environment variable:

```shell
  export AFD_SECONDARY_HOST_NAME=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_JAVASE_QUARKUS --output tsv --query defaultHostName)
```

Next we need to add the secondary application as an origin to the origin group. Use the commandline below:

```shell
  az afd origin create \
    --resource-group $RESOURCE_GROUP \
    --host-name $AFD_SECONDARY_HOST_NAME \
    --profile-name $AFD_PROFILE_NAME \
    --origin-group-name $AFD_ORIGIN_GROUP_NAME \
    --origin-host-header $AFD_SECONDARY_HOST_NAME \
    --origin-name quarkus \
    --priority 1 \
    --weight 1000 \
    --enabled-state Enabled \
    --http-port 80 \
    --https-port 443
```

<!-- workflow.directOnly()

  export RESULT=$(az afd origin show --origin-name springboot --origin-group-name $AFD_ORIGIN_GROUP_NAME --profile-name $AFD_PROFILE_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  if [[ "$RESULT" != Succeeded ]]; then
    az group delete --name $RESOURCE_GROUP --yes || true
    echo "Azure Front Door Origin - springboot - was not provisioned properly"
    exit 1
  fi
  export RESULT=$(az afd origin show --origin-name quarkus --origin-group-name $AFD_ORIGIN_GROUP_NAME --profile-name $AFD_PROFILE_NAME --resource-group $RESOURCE_GROUP --output tsv --query provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Front Door Origin Group - quarkus - was not provisioned properly"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

3m
