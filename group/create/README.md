
# Create an Azure Resource Group

[![group/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/group_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/group_create_README_md.yml)

## Prerequisites

This example assume you are logged into Azure CLI and have set your default
subscription, if you have NOT done so please go to our top-level
[README](../../README.md)

## Create the Resource Group

To setup the environment variables needed to create the Resource Group execute
the command lines below:

<!-- workflow.run()
  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 0 * * 1) -->
<!-- workflow.skip() -->
```shell
  export RESOURCE_GROUP=joaz-rg
  export REGION=pick_your_closest_region
```

<!-- workflow.run()
  if [[ -z $RESOURCE_GROUP ]]; then
    export RESOURCE_GROUP=joaz-rg-$RANDOM
    echo "Using '"$RESOURCE_GROUP"' as resource group"
  fi

  -->

To create the Resource Group use the following command line:

```shell
  az group create --name $RESOURCE_GROUP --location $REGION
```

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

* [Create an Azure Container Apps environment](../../containerapp/create-environment/README.md)
* [Create an Azure Kubernetes Service cluster](../../containers/aks/create/README.md)
* [Create an Azure Spring Cloud](../../compute/spring-cloud/create/README.md)

## Reference documentation

* [Manage resource groups and template deployments](https://docs.microsoft.com/cli/azure/group)

## Terraform snippets

If you want to use Terraform please see the snippets below:

* [main.tf](main.tf)
* [outputs.tf](outputs.tf)
* [variables.tf](variables.tf)

1m
