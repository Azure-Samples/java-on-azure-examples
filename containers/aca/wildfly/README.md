# Deploy WildFly

[![containers/aca/wildfly/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containers_aca_wildfly_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containers_aca_wildfly_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Push a WildFly Docker image to Azure Container Registry](../../acr/wildfly/README.md)
1. [Create an Azure Container Apps environment](../create-environment/README.md)

## Deploy WildFly

<!-- workflow.cron(0 8 * * 2) -->
<!-- workflow.include(../../acr/wildfly/README.md) -->
<!-- workflow.include(../../aca/create-environment/README.md) -->

To deploy the WildFly container image to Azure Container Apps use the command 
line below.

```shell
  export ACA_WILDFLY=wildfly

  az containerapp create \
    --name $ACA_WILDFLY \
    --resource-group $RESOURCE_GROUP \
    --environment $ACA_ENVIRONMENT_NAME \
    --image $ACR_NAME.azurecr.io/$ACR_WILDFLY_IMAGE \
    --target-port 8080 \
    --ingress 'external' \
    --registry-server $ACR_NAME.azurecr.io \
    --min-replicas 1
```

<!-- workflow.directOnly()
  sleep 60
  export URL=https://$(az containerapp show --resource-group $RESOURCE_GROUP --name $ACA_WILDFLY --query properties.configuration.ingress.fqdn --output tsv)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"custom WildFly"* ]]; then
    echo "Response did not contain 'custom WildFly'"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
