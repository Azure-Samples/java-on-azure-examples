
# Deploy a Quarkus application

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../../acr/create/)
1. [Create an 'acrpull' Service Principal](../../acr/create-acrpull-service-principal/)
1. [Push a Quarkus Docker application to Azure Container Registry](../../acr/quarkus/)

## Deploy the Quarkus application

<!-- workflow.include(../../acr/quarkus/README.md) -->

To deploy the application use the following command line:

```shell
  export ACI_QUARKUS=aci-quarkus-$RANDOM

  az container create \
    --resource-group $RESOURCE_GROUP \
    --name $ACI_QUARKUS \
    --image $ACR.azurecr.io/acr-quarkus:latest \
    --registry-login-server $ACR.azurecr.io \
    --registry-username $ACR_PULL_SERVICE_PRINCIPAL_ID \
    --registry-password $ACR_PULL_SERVICE_PRINCIPAL_PASSWORD \
    --dns-name-label $ACI_QUARKUS_NAME \
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

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
