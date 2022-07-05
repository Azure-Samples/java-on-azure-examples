
# Deploy a GraalVM application

[![aks/graalvm/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_graalvm_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_graalvm_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Push a GraalVM Docker image to Azure Container Registry](../../acr/graalvm/README.md)
1. [Create settings.xml using admin access keys](../../acr/create-settings-xml/README.md)
1. [Deploy an Azure Kubernetes Service cluster](../create/README.md)
1. [Create a Kube config for your Azure Kubernetes Service cluster (using admin access keys)](../create-kube-config/README.md)
1. [Update your AKS cluster to use your Azure Container Registry](../use-your-acr/README.md)

## Deploy a GraalVM application

<!-- workflow.cron(0 7 * * 0) -->
<!-- workflow.include(../../acr/graalvm/README.md) -->
<!-- workflow.include(../create-kube-config/README.md) -->
<!-- workflow.include(../use-your-acr/README.md) -->
<!-- workflow.run() 

  cd aks/graalvm

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
kubectl get service/graalvm
```

If the `EXTERNAL-IP` column has no IP address yet keep repeating the command as
it might take a while before AKS has assigned a public IP.

Once the `EXTERNAL-IP` shows up open your browser to `http://EXTERNAL-IP/helloworld`.

It should tell you:

```text
Hello
```

## Cleanup

<!-- workflow.directOnly()
  
  sleep 240
  export URL=http://$(kubectl get service/graalvm --output jsonpath="{.status.loadBalancer.ingress[0].ip}")/helloworld
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello"* ]]; then
    echo "Response did not contain 'Hello'"
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
* [GraalVM documentation](https://www.graalvm.org/docs/)

1m
