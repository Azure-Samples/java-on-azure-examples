# Create a manual job

[![containerapp/create-manual-job/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_create-manual-job_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/containerapp_create-manual-job_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Container Registry](../../acr/create/README.md)
1. [Build and push a Hello World Job application to Azure Container Registry](../../acr/helloworldjob/README.md)
1. [Create an Azure Container Apps environment](../create-environment/README.md)

## Create the manual job

<!-- workflow.cron(0 0 * * 4) -->
<!-- workflow.include(../../acr/helloworldjob/README.md) -->
<!-- workflow.include(../create-environment/README.md) -->

<!-- workflow.skip() -->
```shell
  export ACA_JOB_NAME=aca-job-$RANDOM
```

<!-- workflow.run()
if [[ -z $ACA_JOB_NAME ]]; then
  export ACA_JOB_NAME=aca-job-$RANDOM
fi
 -->

To create the manual job use the command line below.

```shell
  az containerapp job create \
    --name $ACA_JOB_NAME \
    --resource-group $RESOURCE_GROUP \
    --environment $ACA_ENVIRONMENT_NAME \
    --trigger-type Manual \
    --replica-timeout 1800 \
    --replica-retry-limit 1 \
    --replica-completion-count 1 \
    --parallelism 1 \
    --image $ACR_HELLOWORLDJOB_IMAGE 
```

<!-- workflow.directOnly()

  sleep 60
  export RESULT=$(az containerapp job show --name $ACA_JOB_NAME --resource-group $RESOURCE_GROUP --output tsv --query properties.provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure Container Apps job $ACA_JOB_NAME was not provisioned properly"
    exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
