# Deploy Glassfish on ACA

[![containerapp/glassfish/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_glassfish_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_glassfish_README_md.yml)

## Prerequisites

<!-- 

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 8 * * 3) -->
<!-- workflow.include(../../acr/glassfish/README.md) -->
<!-- workflow.include(../create-environment/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Build and push a Glassfish application to Azure Container Registry](../../acr/glassfish/README.md)
1. [Create an Azure Container Apps environment](../create-environment/README.md)

## Deploy Glassfish

To deploy the Glassfish container image to Azure Container Apps use the command 
line below.

```shell
  export ACA_GLASSFISH=glassfish

  az containerapp create \
    --name $ACA_GLASSFISH \
    --resource-group $RESOURCE_GROUP \
    --environment $ACA_ENVIRONMENT_NAME \
    --image $ACR_NAME.azurecr.io/$ACR_GLASSFISH_IMAGE \
    --target-port 8080 \
    --ingress 'external' \
    --registry-server $ACR_NAME.azurecr.io \
    --min-replicas 1

  az containerapp show \
    --resource-group $RESOURCE_GROUP \
    --name $ACA_GLASSFISH \
    --query properties.configuration.ingress.fqdn \
    --output tsv
```

Then open your browser to the URL echoed above and you should see:

```text
And this is served by a custom Glassfish coming from your own Azure
Container Registry.
```

<!-- workflow.directOnly()

  sleep 120
  export URL=https://$(az containerapp show --resource-group $RESOURCE_GROUP --name $ACA_GLASSFISH --query properties.configuration.ingress.fqdn --output tsv)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"custom Glassfish"* ]]; then
    echo "Response did not contain 'custom Glassfish'"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

* [Manage Azure Container Apps](https://docs.microsoft.com/cli/azure/containerapp)
* [Azure Container Apps documentation](https://docs.microsoft.com/azure/container-apps)

1m
