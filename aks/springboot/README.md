
# Deploy a Spring Boot application

[![aks/springboot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_springboot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_springboot_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Create settings.xml using admin access keys](../../acr/create-settings-xml/README.md)
1. [Deploy an Azure Kubernetes Service cluster](../create/README.md)
1. [Create a Kube config for your Azure Kubernetes Service cluster (using admin access keys)](../create-kube-config/README.md)
1. [Update your AKS cluster to use your Azure Container Registry](../use-your-acr/README.md)

## Build the example

<!-- workflow.cron(0 4 * * 6) -->
<!-- workflow.include(../create-kube-config/README.md) -->
<!-- workflow.include(../use-your-acr/README.md) -->
<!-- workflow.run() 

  cd aks/springboot

  -->

To build the JAR file use the following Maven command line.

````shell
  mvn package
````

## Run example locally

To run the example locally use the following Maven command line.

<!-- workflow.skip() -->
````shell
  mvn spring-boot:run
````

## Push the Docker image to your Azure Container Registry

````shell
 az acr build --registry $ACR_NAME --image springboot:latest .
````

## Deploying to the AKS cluster

First open the `deployment.yml` file in an editor and replace `ACR` with the
name of your Azure Container Registry OR execute the command line below:

```shell
  sed -i "s/ACR/$ACR_NAME/g" deployment.yml
```

Then execute the command below to deploy to the AKS cluster:

```shell
  kubectl apply -f deployment.yml
```

> Note in a production environment you should use an Ingress controller instead
> of directly exposing the IP address

To get the public IP address use the following command.

<!-- workflow.skip() -->
```shell
  kubectl get service/springboot
```

If the `EXTERNAL-IP` column has no IP address yet keep repeating the command as
it might take a while before AKS has assigned a public IP.

Once the `EXTERNAL-IP` shows up open your browser to `http://EXTERNAL-IP`.

It should show you a page with the text `Hello World`.

## Cleanup

<!-- workflow.directOnly()
  
  sleep 240
  export URL=http://$(kubectl get service/springboot --output jsonpath="{.status.loadBalancer.ingress[0].ip}")
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello World"* ]]; then
    echo "Response did not contain 'Hello World'"
    exit 1
  fi

  -->

<!-- workflow.run() 

  cd ../..
  
  -->

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

* [Commands to manage Azure Kubernetes Services](https://docs.microsoft.com/cli/azure/aks)
* [Azure Kubernetes Service Documentation](https://docs.microsoft.com/azure/aks/)
* [kubectl](https://kubernetes.io/docs/reference/kubectl/)

3m
