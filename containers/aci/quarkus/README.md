
# Deploy a Quarkus application

[![containers/aci/quarkus/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containers_aci_quarkus_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containers_aci_quarkus_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../../general/group/create/README.md)
1. [Create an Azure Container Registry](../../../containers/acr/create/README.md)
1. [Create an 'acrpull' Service Principal](../../../containers/acr/create-acrpull-service-principal/README.md)
1. [Push a Quarkus Docker application to Azure Container Registry](../../../containers/acr/quarkus/README.md)

## Deploy the Quarkus application

<!-- workflow.cron(0 10 * * 2) -->
<!-- workflow.include(../../acr/create-acrpull-service-principal/README.md) -->
<!-- workflow.include(../../acr/quarkus/README.md) -->

To deploy the application use the following command line:

```shell
  export ACI_QUARKUS=aci-quarkus-$RANDOM

  az container create \
    --resource-group $RESOURCE_GROUP \
    --name $ACI_QUARKUS \
    --image $ACR_NAME.azurecr.io/$ACR_QUARKUS_IMAGE \
    --registry-login-server $ACR_NAME.azurecr.io \
    --registry-username $ACR_PULL_SERVICE_PRINCIPAL_ID \
    --registry-password $ACR_PULL_SERVICE_PRINCIPAL_PASSWORD \
    --dns-name-label $ACI_QUARKUS \
    --ports 8080

  echo `az container show \
    --resource-group $RESOURCE_GROUP \
    --name $ACI_QUARKUS \
    --query ipAddress.fqdn \
    --output tsv`:8080
```

Then open your browser to the URL echoed above and you should see:

```text
hello
```

<!-- workflow.directOnly()

export URL=http://$(az container show --resource-group $RESOURCE_GROUP --name $ACI_QUARKUS --query ipAddress.fqdn --output tsv):8080
export RESULT=$(curl $URL)

az group delete --name $RESOURCE_GROUP --yes || true

if [[ "$RESULT" != *"hello"* ]]; then
  echo "Response did not contain 'hello'"
  exit 1
fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
