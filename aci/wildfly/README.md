
# Deploy WildFly

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../../acr/create/)
1. [Create an 'acrpull' Service Principal](../../acr/create-acrpull-service-principal/)
1. [Push a WildFly Docker image to Azure Container Registry](../../acr/wildfly/)

## Deploy WildFly

To deploy WildFly use the following command line:

```shell
  export ACI_WILDFLY=aci-wildfly-$RANDOM

  az container create \
    --resource-group $RESOURCE_GROUP \
    --name $ACI_WILDFLY \
    --image $ACR.azurecr.io/acr-wildfly:latest \
    --registry-login-server $ACR.azurecr.io \
    --registry-username $ACR_PULL_SERVICE_PRINCIPAL_ID \
    --registry-password $ACR_PULL_SERVICE_PRINCIPAL_PASSWORD \
    --dns-name-label $ACI_WILDFLY_NAME \
    --ports 8080

  echo `az container show \
    --resource-group $RESOURCE_GROUP \
    --name $ACI_WILDFLY \
    --query ipAddress.fqdn \
    --output tsv`:8080
```

Then open your browser to the URL echoed above and you should see:

```text
And this is served by a custom WildFly using a Docker image coming from our 
own Azure Container Registry.
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

2m
