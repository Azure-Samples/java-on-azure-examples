
# Deploy Tomcat

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../../acr/create/)
1. [Create an 'acrpull' Service Principal](../../acr/create-acrpull-service-principal/)
1. [Push a Tomcat Docker image to Azure Container Registry](../../acr/tomcat/)

## Deploy Tomcat

To deploy Tomcat the following command line:

```shell
  export ACI_TOMCAT=aci-tomcat-$RANDOM

  az container create \
    --resource-group $RESOURCE_GROUP \
    --name $ACI_TOMCAT \
    --image $ACR.azurecr.io/acr-tomcat:latest \
    --registry-login-server $ACR.azurecr.io \
    --registry-username $ACR_PULL_SERVICE_PRINCIPAL_ID \
    --registry-password $ACR_PULL_SERVICE_PRINCIPAL_PASSWORD \
    --dns-name-label $ACI_TOMCAT_NAME \
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

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
