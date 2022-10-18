# Deploy Tomcat

[![containerapp/tomcat/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_tomcat_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_tomcat_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Push a Tomcat Docker image to Azure Container Registry](../../acr/tomcat/README.md)
1. [Create an Azure Container Apps environment](../create-environment/README.md)

## Deploy Tomcat

<!-- workflow.cron(0 1 * * 4) -->
<!-- workflow.include(../../acr/tomcat/README.md) -->
<!-- workflow.include(../create-environment/README.md) -->

To deploy the Tomcat container image to Azure Container Apps use the command 
lines below.

```shell
  export ACA_TOMCAT=tomcat

  az containerapp create \
    --name $ACA_TOMCAT \
    --resource-group $RESOURCE_GROUP \
    --environment $ACA_ENVIRONMENT_NAME \
    --image $ACR_NAME.azurecr.io/$ACR_TOMCAT_IMAGE \
    --target-port 8080 \
    --ingress 'external' \
    --registry-server $ACR_NAME.azurecr.io \
    --min-replicas 1

  az containerapp show \
    --resource-group $RESOURCE_GROUP \
    --name $ACA_TOMCAT \
    --query properties.configuration.ingress.fqdn
```

Then open your browser to the URL echoed above and you should see:

```text
And this is served by a custom Tomcat using a Docker image coming from
our own Azure Container Registry.
```

<!-- workflow.directOnly()

  sleep 60
  export URL=https://$(az containerapp show --resource-group $RESOURCE_GROUP --name $ACA_TOMCAT --query properties.configuration.ingress.fqdn --output tsv)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"custom Tomcat"* ]]; then
    echo "Response did not contain 'custom Tomcat'"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

* [Manage Azure Container Apps](https://docs.microsoft.com/cli/azure/containerapp)
* [Azure Container Apps documentation](https://docs.microsoft.com/azure/container-apps)

1m
