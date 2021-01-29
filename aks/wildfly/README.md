
# Deploy WildFly

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Create an Azure Container Registry](../../acr/create/)
1. [Push a WildFly Docker image to Azure Container Registry](../../acr/wildfly/)
1. [Create settings.xml using admin access keys](../../acr/create-settings-xml/)
1. [Deploy an Azure Kubernetes Service cluster](../create/)
1. [Create a Kube config for your Azure Kubernetes Service cluster (using admin access keys)](../create-kube-config/)
1. [Update your AKS cluster to use your Azure Container Registry](../use-your-acr/)

## Deploy WildFly

<!-- workflow.include(../use-your-acr/README.md) -->

First open the `deployment.yml` file in an editor and replace `ACR` with the
name of your registry OR execute the command line below:

```shell
  sed -i "" "s/ACR/$ACR/g" deployment.yml
```

Then execute the command below to deploy to the AKS cluster.

```shell
kubectl apply -f deployment.yml
```

> Note in a production environment you should use an Ingress controller instead
> of directly exposing the IP address

To get the public IP address use the following command.

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

Do NOT forget to remove the resources once you are done running the example.

1m
