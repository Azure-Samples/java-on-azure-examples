
# Deploy WildFly

[![aks/wildfly/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_wildfly_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_wildfly_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Push a WildFly Docker image to Azure Container Registry](../../acr/wildfly/README.md)
1. [Create settings.xml using admin access keys](../../acr/create-settings-xml/README.md)
1. [Deploy an Azure Kubernetes Service cluster](../create/README.md)
1. [Create a Kube config for your Azure Kubernetes Service cluster (using admin access keys)](../create-kube-config/README.md)
1. [Update your AKS cluster to use your Azure Container Registry](../use-your-acr/README.md)

## Deploy WildFly

<!-- workflow.cron(0 5 * * 6) -->
<!-- workflow.include(../../acr/wildfly/README.md) -->
<!-- workflow.include(../create-kube-config/README.md) -->
<!-- workflow.include(../use-your-acr/README.md) -->
<!-- workflow.run() 

  cd aks/wildfly

  -->

First open the `deployment.yml` file in an editor and replace `ACR` with the
name of your registry OR execute the command line below:

```shell
  sed -i "s/ACR/$ACR_NAME/g" deployment.yml
```

Then execute the command below to deploy to the AKS cluster.

```shell
  kubectl apply -f deployment.yml
```

> Note in a production environment you should use an Ingress controller instead
> of directly exposing the IP address

To get the public IP address use the following command.

<!-- workflow.skip() -->
```
kubectl get service/wildfly
```

If the `EXTERNAL-IP` column has no IP address yet keep repeating the command as
it might take a while before AKS has assigned a public IP.

Once the `EXTERNAL-IP` shows up open your browser to `http://EXTERNAL-IP`.

It should tell you:

```text
And this is served by a custom WildFly using a Docker image coming from our 
own Azure Container Registry.
```

## Cleanup

<!-- workflow.directOnly()
  
  sleep 240
  export URL=http://$(kubectl get service/wildfly --output jsonpath="{.status.loadBalancer.ingress[0].ip}")
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"custom WildFly"* ]]; then
    echo "Response did not contain 'custom WildFly'"
    exit 1
  fi

  -->

<!-- workflow.run() 

  cd ../..
  
  -->

Do NOT forget to remove the resources once you are done running the example.

1m
