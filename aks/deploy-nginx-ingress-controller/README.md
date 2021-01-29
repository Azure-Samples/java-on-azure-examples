
# Deploy an NGINX Ingress Controller using Helm 2

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Kubernetes Service cluster](../create/)
1. [Create Kube config file for your AKS cluster (using admin access)](../create-kube-config/)
1. [Deploy Tiller using Helm 2](../deploy-tiller/)

And additionally it assumes you have installed both `helm` and `kubectl`. If you
need to install `helm`, please go to [Installing Helm 2](https://v2.helm.sh/docs/using_helm/#installing-helm).
If you need to install `kubectl`, please go to [Install and Setup kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)

## Create the Kubernetes namespace

<!-- workflow.include(../deploy-tiller/README.md) -->

We will create a separate Kubernetes namespace which will be used for deploying
the NGINX Ingress Controller.

To do so use the following command line:

```shell
 kubectl create namespace ingress-basic
```

Note this example assumes that you have already configured `kubectl` to use the
right context.

## Deploy the NGINX Ingress Controller

Use the following command line to deploy an NGINX Ingress Controller on your AKS
cluster:

```shell
 helm install stable/nginx-ingress --namespace ingress-basic --name nginx-ingress \
      --set controller.replicaCount=2 \
      --set controller.nodeSelector.'beta.kubernetes.io/os'=linux \
      --set defaultBackend.nodeSelector.'beta.kubernetes.io/os'=linux \
```

## Get the external IP of the NGINX Ingress controller

To get the External IP of the NGINX Ingress Controller use the command line below:

```shell
 kubectl --namespace ingress-basic get services -o wide nginx-ingress-controller
```

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
