
# Create an Azure OpenAI account

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)


## Create an Azure OpenAI account

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=eastus
  fi

  -->
<!-- workflow.cron(0 17 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->


_Before you can create an Azure OpenAI account on Azure you have to be registered, please register [here](https://customervoice.microsoft.com/Pages/ResponsePage.aspx?id=v4j5cvGGr0GRqy180BHbR7en2Ais5pxKtso_Pz4b1_xUOFA5Qk1UWDRBMjg0WFhPMkIzTzhKQ1dWNyQlQCN0PWcu])._


To create an Azure OpenAI account use the following command lines:

```shell
  export COG_AZURE_OPENAI_NAME=cog-$RANDOM

  az cognitiveservices account create \
    --name $COG_AZURE_OPENAI_NAME \
    --resource-group $RESOURCE_GROUP \
    --location eastus \
    --kind OpenAI \
    --sku S0 \
    --yes
```

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az cognitiveservices account show --name $COG_AZURE_OPENAI_NAME --resource-group $RESOURCE_GROUP --output tsv --query properties.provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure OpenAI account " $COG_AZURE_OPENAI_NAME " was not created successfully"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

1m
