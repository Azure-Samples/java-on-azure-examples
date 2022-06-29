
# Create a Kubeconfig file using admin access

[![aks/create-kube-config/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_create-kube-config_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_create-kube-config_README_md.yml)

```text
Note for production environments we recommend you configure RBAC to
limit access to your Kubernetes cluster based on roles.
```

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Deploy an Azure Kubernetes Service cluster](../create/README.md)

## Create a Kubeconfig file usin admin access

<!-- workflow.cron(0 1 * * 6) -->
<!-- workflow.include(../create/README.md) -->
<!-- workflow.run()

cd aks/create-kube-config

  -->

To create the Kubeconfig file use the following command line:

```shell
  az aks get-credentials --resource-group $RESOURCE_GROUP --name $AKS --admin --file config
````

Once the command completes the Kubeconfig file is stored in a file named `config`

## Setting the KUBECONFIG environment variable

Set the KUBECONFIG environment variable using the command line below:

```shell
  export KUBECONFIG=$PWD/config
```

<!-- workflow.run()

cd ../..

  -->

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ ! -f $KUBECONFIG ]]; then
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done with the example.

## Reference documentation

* [Commands to manage Azure Kubernetes Services](https://docs.microsoft.com/cli/azure/aks)
* [Azure Kubernetes Service Documentation](https://docs.microsoft.com/azure/aks/)

1m
