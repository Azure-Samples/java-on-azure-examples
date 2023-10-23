
# Create an GPT 3.5 model

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure OpenAI account](../create-openai-account/README.md)

## Create an Azure OpenAI account

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=eastus
  fi

  -->
<!-- workflow.cron(0 18 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->
<!-- workflow.include(../create-openai-account/README.md) -->

To create an GPT 3.5 model use the following command lines:

```shell
  az cognitiveservices account deployment create \
    --name $COG_AZURE_OPENAI_NAME \
    --resource-group  $RESOURCE_GROUP \
    --deployment-name gpt-35-turbo \
    --model-name gpt-35-turbo \
    --model-version "0613" \
    --model-format OpenAI \
    --sku-capacity "1" \
    --sku-name "Standard"
```

## Cleanup

<!-- workflow.directOnly()

  export RESULT=$(az cognitiveservices account deployment show --name $COG_AZURE_OPENAI_NAME --deployment-name gpt-35-turbo --resource-group $RESOURCE_GROUP --output tsv --query properties.provisioningState)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != Succeeded ]]; then
    echo "Azure OpenAI GPT 3.5 model was not created successfully"
    exit 1
  fi

  -->

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

1m
