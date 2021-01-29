
# Create a Kubeconfig file using admin access

```text
Note for production environments we recommend you configure RBAC to
limit access to your Kubernetes cluster based on roles.
```

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Kubernetes Service cluster](../create/)

## Create a Kubeconfig file usin admin access

<!-- workflow.include(../create/README.md) -->

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

## Cleanup

Do NOT forget to remove the resources once you are done with the example.

1m