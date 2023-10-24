
# Chat with Semantic Kernel and GPT 3.5

## Prerequisites

This example assumes you have previously completed the following example:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure OpenAI account](../create-openai-account/README.md)
1. [Create a GPT 3.5 model](../create-gpt35-model/README.md)

## Create an Azure OpenAI account

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=eastus
  fi

  -->
<!-- workflow.cron(0 18 * * 4) -->
<!-- workflow.include(../../group/create/README.md) -->
<!-- workflow.include(../create-openai-account/README.md) -->
<!-- workflow.include(../create-gpt35-model/README.md) -->

To chat with Semantic Kernel and GPT 3.5 we need to setup some 
environment variables.

```shell
 export OPENAI_CLIENT_TYPE=AZURE_OPEN_AI
 export AZURE_OPEN_AI_KEY=$(az cognitiveservices account keys list --name $COG_AZURE_OPENAI_NAME --resource-group $RESOURCE_GROUP --output tsv --query key1)
 export AZURE_OPEN_AI_ENDPOINT=$(az cognitiveservices account show --name $COG_AZURE_OPENAI_NAME --resource-group $RESOURCE_GROUP --output tsv --query properties.endpoint)
```

Now that we have that setup we can build the command line application
using the command line below:

```shell
  mvn clean package
```

To run the application use the command line below:

<!-- workflow.skip() -->
```shell
  java -jar target/chat.jar
```

## Cleanup

<!-- workflow.directOnly()

  az group delete --name $RESOURCE_GROUP --yes || true

  -->

Do NOT forget to remove the resources once you are done running the example.

## Reference documentation

1m
