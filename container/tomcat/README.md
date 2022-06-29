
# Deploy Tomcat

[![container/tomcat/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/container_tomcat_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/container_tomcat_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Create an 'acrpull' Service Principal](../../acr/create-acrpull-service-principal/README.md)
1. [Push a Tomcat Docker image to Azure Container Registry](../../acr/tomcat/README.md)

## Deploy Tomcat

<!-- workflow.cron(0 1 * * 1) -->
<!-- workflow.include(../../acr/create-acrpull-service-principal/README.md) -->
<!-- workflow.include(../../acr/tomcat/README.md) -->

To deploy Tomcat the following command line:

```shell
  export ACI_TOMCAT=aci-tomcat-$RANDOM

  az container create \
    --resource-group $RESOURCE_GROUP \
    --name $ACI_TOMCAT \
    --image $ACR_NAME.azurecr.io/$ACR_TOMCAT_IMAGE \
    --registry-login-server $ACR_NAME.azurecr.io \
    --registry-username $ACR_PULL_SERVICE_PRINCIPAL_ID \
    --registry-password $ACR_PULL_SERVICE_PRINCIPAL_PASSWORD \
    --dns-name-label $ACI_TOMCAT \
    --ports 8080

  echo `az container show \
    --resource-group $RESOURCE_GROUP \
    --name $ACI_TOMCAT \
    --query ipAddress.fqdn \
    --output tsv`:8080
```

Then open your browser to the URL echoed above and you should see:

```text
And this is served by a custom Tomcat using a Docker image coming from our 
own Azure Container Registry.
```

<!-- workflow.directOnly()

  export URL=http://$(az container show --resource-group $RESOURCE_GROUP --name $ACI_TOMCAT --query ipAddress.fqdn --output tsv):8080
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"custom Tomcat"* ]]; then
    echo "Response did not contain 'custom Tomcat'"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
