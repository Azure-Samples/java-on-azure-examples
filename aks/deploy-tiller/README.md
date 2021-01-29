
# Deploy Tiller using Helm 2

```text
Note for production environments we recommend you configure RBAC to
limit access to what a Helm client and Tiller can access
```

## Prerequisites

This example assumes you have previously completed the following examples.

1. [Create an Azure Resource Group](../../group/create/)
1. [Deploy an Azure Kubernetes Service cluster](../create/)
1. [Create Kube config file using admin access](../create-kube-config/)

And additionally it assumes you have installed both `helm` and `kubectl`. If you
need to install `helm`, please go to [Installing Helm 2](https://v2.helm.sh/docs/using_helm/#installing-helm).
If you need to install `kubectl`, please go to [Install and Setup kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)

## Create a service account for Tiller

<!-- workflow.include(../create-kube-config/README.md) -->

In order for tiller to work it needs a service account. The command line below
will create a service account:

```shell
 kubectl --namespace kube-system create serviceaccount tiller
```

Note this example assumes that you have already configured `kubectl` to use the
right context.

## Add a cluster role binding for the service account

To add the necessary cluster role binding use:

```shell
 kubectl create clusterrolebinding tiller --clusterrole cluster-admin \
         --serviceaccount=kube-system:tiller
```

## Deploy Tiller

Use the following command line to deploy Tiller on your Azure Kubernetes Service
cluster:

```shell
 helm init --service-account tiller --upgrade
```

## Cleanup

Do NOT forget to remove the resources you have created once you are done running
the example.
