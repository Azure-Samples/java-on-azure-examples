
# Deploy a web application on a managed JBoss EAP

[![appservice/jboss-eap-helloworld/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_jboss-eap-helloworld_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_jboss-eap-helloworld_README_md.yml)

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)

<!-- workflow.cron(0 17 * * 5) -->
<!-- workflow.include(../create-plan/README.md) -->

## Build the example

<!-- workflow.run() 

  cd appservice/jboss-eap-helloworld

  -->

````shell
  mvn clean package
````

## Deploy the web application on the managed JBoss EAP

To deploy the example use the following Maven command line.

````shell
  export APPSERVICE_JBOSS_EAP_HELLOWORLD=appservice-jboss-eap-helloworld-$RANDOM

  mvn azure-webapp:deploy \
    -DappName=$APPSERVICE_JBOSS_EAP_HELLOWORLD \
    -DappServicePlan=$APPSERVICE_PLAN \
    -DresourceGroup=$RESOURCE_GROUP
````

<!-- workflow.run()

  sleep 240
  cd ../..

  -->

<!-- workflow.directOnly() 

  export RESULT=$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_JBOSS_EAP_HELLOWORLD --output tsv --query state)
  if [[ "$RESULT" != Running ]]; then
    echo 'Web application is NOT running'
    az group delete --name $RESOURCE_GROUP --yes || true
    exit 1
  fi
  export URL=https://$(az webapp show --resource-group $RESOURCE_GROUP --name $APPSERVICE_JBOSS_EAP_HELLOWORLD --output tsv --query defaultHostName)
  export RESULT=$(curl $URL)
  az group delete --name $RESOURCE_GROUP --yes || true
  if [[ "$RESULT" != *"Hello World"* ]]; then
    echo "Response did not contain 'Hello World'"
    exit 1
  fi

  -->

Once the command completes you will be able to see the example by using your 
web browser and going to the ```xxxxx.azurewebsites.net``` address the command
echoes.

### Properties supported by the example

The example supports the following properties that you can pass in as
-Dname=value to the Maven command line to customize your deployment.

| name                   | description                  |
|------------------------|------------------------------|
| `appName`              | the Application Name         |
| `appServicePlan`       | the App Service plan to use  |
| `javaVersion`          | the Java version to use      |
| `region`               | the Region to use            |
| `resourceGroup`        | the Resource Group to use    |
| `webContainer`         | the Web Container to use     |

## Cleanup

Do NOT forget to remove the resources once you are done running the example.
