# Deploy a Helidon application

[![containerapp/helidon/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_helidon_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_helidon_README_md.yml)

## Prerequisites

<!-- 

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 7 * * 3) -->
<!-- workflow.include(../../acr/helidon/README.md) -->
<!-- workflow.include(../create-environment/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Push a Helidon application to Azure Container Registry](../../acr/helidon/README.md)
1. [Create an Azure Container Apps environment](../create-environment/README.md)

## Deploy the Helidon application

To deploy the Helidon container image to Azure Container Apps use the
command lines below.

```shell
  export ACA_HELIDON=helidon

  az containerapp create \
    --name $ACA_HELIDON \
    --resource-group $RESOURCE_GROUP \
    --environment $ACA_ENVIRONMENT_NAME \
    --image $ACR_NAME.azurecr.io/$ACR_HELIDON_IMAGE \
    --target-port 8080 \
    --ingress 'external' \
    --registry-server $ACR_NAME.azurecr.io \
    --min-replicas 1

  echo $(az containerapp show \
    --resource-group $RESOURCE_GROUP \
    --name $ACA_HELIDON \
    --query properties.configuration.ingress.fqdn \
    --output tsv)/greet
```

Then open your browser to the URL echoed above and you should see:

```text
{"message":"Hello World!"}
```

<!-- workflow.directOnly()

  sleep 60
  export URL=https://$(az containerapp show --resource-group $RESOURCE_GROUP --name $ACA_HELIDON --query properties.configuration.ingress.fqdn --output tsv)/greet
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello World"* ]]; then
    echo "Response did not contain 'Hello World'"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

* [Manage Azure Container Apps](https://docs.microsoft.com/cli/azure/containerapp)
* [Azure Container Apps documentation](https://docs.microsoft.com/azure/container-apps)

1m
