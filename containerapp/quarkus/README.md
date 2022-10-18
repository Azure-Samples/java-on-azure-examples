# Deploy a Quarkus application

[![containerapp/quarkus/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_quarkus_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_quarkus_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Push a Quarkus application to Azure Container Registry](../../acr/quarkus/README.md)
1. [Create an Azure Container Apps environment](../create-environment/README.md)

## Deploy the Quarkus application

<!-- workflow.cron(0 1 * * 2) -->
<!-- workflow.include(../../acr/quarkus/README.md) -->
<!-- workflow.include(../create-environment/README.md) -->

To deploy the Quarkus container image to Azure Container Apps use the
command lines below.

```shell
  export ACA_QUARKUS=quarkus

  az containerapp create \
    --name $ACA_QUARKUS \
    --resource-group $RESOURCE_GROUP \
    --environment $ACA_ENVIRONMENT_NAME \
    --image $ACR_NAME.azurecr.io/$ACR_QUARKUS_IMAGE \
    --target-port 8080 \
    --ingress 'external' \
    --registry-server $ACR_NAME.azurecr.io \
    --min-replicas 1

  az containerapp show \
    --resource-group $RESOURCE_GROUP \
    --name $ACA_QUARKUS \
    --query properties.configuration.ingress.fqdn
```

Then open your browser to the URL echoed above and you should see:

```text
hello
```

<!-- workflow.directOnly()

  sleep 60
  export URL=https://$(az containerapp show --resource-group $RESOURCE_GROUP --name $ACA_QUARKUS --query properties.configuration.ingress.fqdn --output tsv)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"hello"* ]]; then
    echo "Response did not contain 'hello'"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

* [Manage Azure Container Apps](https://docs.microsoft.com/cli/azure/containerapp)
* [Azure Container Apps documentation](https://docs.microsoft.com/azure/container-apps)

1m
