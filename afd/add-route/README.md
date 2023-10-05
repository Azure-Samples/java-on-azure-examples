
# Add route

[![afd/add-route/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_add-route_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/afd_add-route_README_md.yml)

## Prerequisites

<!-- workflow.run()

  if [[ -z $REGION ]]; then
    export REGION=westus
  fi

  -->
<!-- workflow.cron(0 17 * * 1) -->
<!-- workflow.include(../add-origins-to-origin-group/README.md) -->

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure Front Door Profile](../create-profile/README.md)
1. [Create an Azure Front Door Endpoint](../create-endpoint/README.md)
1. [Create an Azure Front Door Origin Group](../create-origin-group/README.md)
1. [Create an Azure App Service Plan](../../appservice/create-plan/README.md)
1. [Deploy a managed JavaSE Spring Boot application](../../appservice/javase-springboot/README.md)
1. [Deploy a managed JavaSE Quarkus application](../../appservice/javase-quarkus/README.md)
1. [Add origins to an Azure Front Door Origin Group](../add-origins-to-origin-group/README.md)

## Add route

We need to add a route to our Front Door to map the endpoint to the origin group. Use the following command line below:


```shell
  az afd route create \
    --resource-group $RESOURCE_GROUP \
    --profile-name $AFD_PROFILE_NAME \
    --endpoint-name $AFD_ENDPOINT_NAME \
    --forwarding-protocol MatchRequest \
    --route-name route \
    --https-redirect Enabled \
    --origin-group $AFD_ORIGIN_GROUP_NAME \
    --supported-protocols Http Https \
    --link-to-default-domain Enabled 
```

The next step is to get the endpoint and browse to it.To get the endpoint Use the following command line:

<!-- workflow.skip() -->
```shell
  az afd endpoint show --resource-group $RESOURCE_GROUP --profile-name $AFD_PROFILE_NAME --endpoint-name $AFD_ENDPOINT_NAME --query hostName --output tsv
```

<!-- workflow.directOnly()

  sleep 300
  export URL=https://$(az afd endpoint show --resource-group $RESOURCE_GROUP --profile-name $AFD_PROFILE_NAME --endpoint-name $AFD_ENDPOINT_NAME --query hostName --output tsv)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello"* ]]; then
      echo "Response did not contain 'Hello'"
      exit 1
  fi

  -->

## Cleanup

Do NOT forget to remove the resources once you are done running the example.

1m
