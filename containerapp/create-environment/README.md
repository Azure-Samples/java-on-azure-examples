# Create an environment

[![containerapp/create-environment/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_create-environment_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_create-environment_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)

## Setup the CLI extensions

<!-- workflow.cron(0 0 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->

Ensure you are running the latest Azure CLI and install the Azure Container
Apps extensions for the CLI using the command lines below:

```shell
  az extension add --name containerapp --upgrade
  az provider register --namespace Microsoft.App
  az provider register --namespace Microsoft.OperationalInsights
```

## Create an environment

Setup the environment variables for the Azure Container Apps environment and its
region using the command lines below:

<!-- workflow.skip() -->
```shell
  export ACA_ENVIRONMENT_NAME=aca$RANDOM
  export ACA_REGION=westus
```

<!-- workflow.run()

  if [[ -z $ACA_ENVIRONMENT_NAME ]]; then
    export ACA_ENVIRONMENT_NAME=aca$RANDOM
    export ACA_REGION=westus
  fi

  -->

To create the Azure Container Apps environment use the following command line:

```shell
  az containerapp env create \
    --name $ACA_ENVIRONMENT_NAME \
    --resource-group $RESOURCE_GROUP \
    --location "$ACA_REGION"
```

<!-- workflow.directOnly()

  sleep 60
  export RESULT=$(az containerapp env show --name $ACA_ENVIRONMENT_NAME --resource-group $RESOURCE_GROUP --output tsv --query properties.provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Container Apps environment $ACA_ENVIRONMENT_NAME was not provisioned properly"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Next steps

* [Deploy a Quarkus application](../quarkus/README.md)
* [Deploy Tomcat](../tomcat/README.md)
* [Deploy WildFly](../wildfly/README.md)

## Reference documentation

* [Manage Azure Container Apps](https://docs.microsoft.com/cli/azure/containerapp)
* [Azure Container Apps documentation](https://docs.microsoft.com/azure/container-apps)

4m
