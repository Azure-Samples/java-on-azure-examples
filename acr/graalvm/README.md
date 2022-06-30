
# Build and push a GraalVM application to ACR

[![acr/graalvm/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_graalvm_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/acr_graalvm_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../create/README.md)

<!-- workflow.cron(0 4 * * 0) -->
<!-- workflow.include(../create/README.md) -->

## Build the example

<!-- workflow.run()

  cd acr/graalvm

  -->

To build the JAR file use the following Maven command line:

```shell
  mvn package
```

## Build the builder image

In order to build the Linux native image we need a GraalVM version that is 
executed on Linux. The command below will generate a Docker image with what we
need.

```shell
  docker build -t builder -f Dockerfile.builder .
```

## Execute the builder image to build the Linux binary

The next step is to use the builder image to generate the Linux binary. Execute
the command line below. Note if you are on Windows please replace $PWD with the
path of the current directory.

```shell
  docker run --rm --tty -v $PWD/../..:/mnt builder mvn -P graalvm -pl acr/graalvm clean install  
```

## Build and push the Docker image to your Azure Container Registry

To build and push the Docker image to your ACR use the command lines below:

```shell
  export ACR_GRAALVM_IMAGE=graalvm:latest

  az acr build --registry $ACR_NAME --image $ACR_GRAALVM_IMAGE .
```

<!-- workflow.run()

  cd ../..

  -->

<!-- workflow.directOnly()

  export RESULT=$(az acr repository show --name $ACR_NAME --image $ACR_GRAALVM_IMAGE)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ -z $RESULT ]]; then
    echo "Unable to find $ACR_GRAALVM_IMAGE image"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

10m
