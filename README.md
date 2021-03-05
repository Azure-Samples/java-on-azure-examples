# Java on Azure Examples

This GitHub repository contains a set of Azure examples specifically for Java 
developers to quickly get started with Azure. Please use the issue tracker to
leave feedback, file issues or to propose other examples.

## Getting started

To work with these examples it is assumed you have the Azure CLI installed, and
you have logged in and set your default subscription. If you haven't done so
follow the steps below.

_Note logging in and setting your default subscription needs to be done once per
 terminal session._

### Install Azure CLI

To setup the Azure CLI, please visit [Install the Azure CLI](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli). And once you are done come back to this README.

### Login into Azure

<!-- workflow.skip() -->
````shell
  az login
````

### Set your default subscription

Get a list of your subscriptions

<!-- workflow.skip() -->
````shell
  az account list --output table
````

Set your default subscription for this session using the subscription id from the previous output

<!-- workflow.skip() -->
````shell
  az account set --subscription "subscription-id"
````

<!-- workflow.run() 
exit 0
  -->

## Azure App Service examples

| Name | Link | Status
| ---- | ---- | ------ 
| 1. [Deploy a web application on a managed Tomcat](appservice/tomcat-helloworld/) | [Workflow](.github/workflows/appservice_tomcat-helloworld_README_md.yml) | ![appservice/tomcat-helloworld/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/appservice/tomcat-helloworld/README.md/badge.svg)
| 2. [Create an App Service Plan](appservice/create-plan/) | [Workflow](.github/workflows/appservice_create-plan_README_md.yml) | ![appservice/create-plan/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/appservice/create-plan/README.md/badge.svg)
| 3. [Delete an App Service Plan](appservice/delete-plan/) | [Workflow](.github/workflows/appservice_delete-plan_README_md.yml) | ![appservice/delete-plan/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/appservice/delete-plan/README.md/badge.svg)
| 4. [Scale your App Service Plan manually](appservice/scale-manually/) | [Workflow](.github/workflows/appservice_scale-manually_README_md.yml) | [![appservice/scale-manually/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_scale-manually_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_scale-manually_README_md.yml)
| 5. [Delete your web application](appservice/delete-webapp/) | [Workflow](.github/workflows/appservice_delete-webapp_README_md.yml) | [![appservice/delete-webapp/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_delete-webapp_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_delete-webapp_README_md.yml)
| 6. [List your web applications](appservice/list-webapp/) | [Workflow](.github/workflows/appservice_list-webapp_README_md.yml) | [![appservice/list-webapp/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_list-webapp_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_list-webapp_README_md.yml)
| 7. [Create a deployment slot](appservice/create-deployment-slot/) | [Workflow](.github/workflows/appservice_create-deployment-slot_README_md.yml) | [![appservice/create-deployment-slot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_create-deployment-slot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_create-deployment-slot_README_md.yml)
| 8. [Deploy to a deployment slot](appservice/deploy-to-deployment-slot/) | [Workflow](.github/workflows/appservice_deploy-to-deployment-slot_README_md.yml) | [![appservice/deploy-to-deployment-slot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_deploy-to-deployment-slot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_deploy-to-deployment-slot_README_md.yml)
| 9. [Deploy Tomcat using a Docker image](appservice/docker-tomcat/) | [Workflow](.github/workflows/appservice_docker-tomcat_README_md.yml) | [![appservice/docker-tomcat/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-tomcat_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-tomcat_README_md.yml)
| 10. [Deploy Jetty using a Docker image](appservice/docker-jetty/) | [Workflow](.github/workflows/appservice_docker-jetty_README_md.yml) | [![appservice/docker-jetty/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-jetty_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-jetty_README_md.yml)
| 11. [Deploy Payara using a Docker image](appservice/docker-payara/) | [Workflow](.github/workflows/appservice_docker-payara_README_md.yml) | [![appservice/docker-payara/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-payara_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-payara_README_md.yml)
| 12. [Deploy Glassfish using a Docker image](appservice/docker-glassfish/) | [Workflow](.github/workflows/appservice_docker-glassfish_README_md.yml) | [![appservice/docker-glassfish/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-glassfish_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-glassfish_README_md.yml)
| 13. [Deploy a Spring Boot application using managed JavaSE](appservice/javase-springboot/) | [Workflow](.github/workflows/appservice_javase-springboot_README_md.yml) | [![appservice/javase-springboot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_javase-springboot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_javase-springboot_README_md.yml)
| 14. [Deploy WildFly using a Docker image](appservice/docker-wildfly/) | [Workflow](.github/workflows/appservice_docker-wildfly_README_md.yml) | [![appservice/docker-wildfly/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-wildfly_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-wildfly_README_md.yml)
| 15. [Deploy a Quarkus application using managed JavaSE](appservice/javase-quarkus/) | [Workflow](.github/workflows/appservice_javase-quarkus_README_md.yml) | [![appservice/javase-quarkus/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_javase-quarkus_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_javase-quarkus_README_md.yml)
| 16. [Deploy a GraalVM application using a Docker image](appservice/docker-graalvm/) | [Workflow](.github/workflows/appservice_docker-graalvm_README_md.yml) | [![appservice/docker-graalvm/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-graalvm_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-graalvm_README_md.yml)
| 17. [Swap a deployment slot](appservice/swap-deployment-slot/) | [Workflow](.github/workflows/appservice_swap-deployment-slot_README_md.yml) | [![appservice/swap-deployment-slot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_swap-deployment-slot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_swap-deployment-slot_README_md.yml)
| 18. [Deploy a web application on a managed JBoss EAP](appservice/jboss-eap-helloworld/) | [Workflow](.github/workflows/appservice_jboss-eap-helloworld_README_md.yml) | [![appservice/jboss-eap-helloworld/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_jboss-eap-helloworld_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_jboss-eap-helloworld_README_md.yml)

## Azure Container Instances examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Deploy a Quarkus application](aci/quarkus/) | [Workflow](.github/workflows/aci_quarkus_README_md.yml) | [![aci/quarkus/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aci_quarkus_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aci_quarkus_README_md.yml)
| 2. [Deploy Tomcat](aci/tomcat/) | [Workflow](.github/workflows/aci_tomcat_README_md.yml) | [![aci/tomcat/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aci_tomcat_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aci_tomcat_README_md.yml)
| 3. [Deploy WildFly](aci/wildfly/) | [Workflow](.github/workflows/aci_wildfly_README_md.yml) | [![aci/wildfly/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aci_wildfly_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aci_wildfly_README_md.yml)

## Azure Container Registry examples

| Name | Link | Status
| ---- | ---- | ------ 
| 1. [Create an Azure Container registry](acr/create/) | [Workflow](.github/workflows/acr_create_README_md.yml) | ![acr/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/create/README.md/badge.svg)
| 2. [Create Maven settings.xml](acr/create-settings-xml/) | [Workflow](.github/workflows/acr_create-settings-xml_README_md.yml) | ![acr/create-settings-xml/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/create-settings-xml/README.md/badge.svg)
| 3. [Create an 'acrpull' Service Principal](acr/create-acrpull-service-principal/) | [Workflow](.github/workflows/acr_create-acrpull-service-principal_README_md.yml) | ![acr/create-acrpull-service-principal/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/create-acrpull-service-principal/README.md/badge.svg)
| 4. [Push a Glassfish Docker image](acr/glassfish/) | [Workflow](.github/workflows/acr_glassfish_README_md.yml) | ![acr/glassfish/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/glassfish/README.md/badge.svg)
| 5. [Push a GraalVM Docker image](acr/graalvm/) | [Workflow](.github/workflows/acr_graalvm_README_md.yml) | ![acr/graalvm/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/graalvm/README.md/badge.svg) 
| 6. [Push a Jetty Docker image](acr/jetty/) | [Workflow](.github/workflows/acr_jetty_README_md.yml) | ![acr/jetty/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/jetty/README.md/badge.svg)
| 7. [Push a Payara Docker image](acr/payara/) | [Workflow](.github/workflows/acr_payara_README_md.yml) | ![acr/payara/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/payara/README.md/badge.svg)
| 8. [Push a Quarkus Docker image](acr/quarkus/) | [Workflow](.github/workflows/acr_quarkus_README_md.yml) | ![acr/quarkus/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/quarkus/README.md/badge.svg)
| 9. [Push a Tomcat Docker image](acr/tomcat/) | [Workflow](.github/workflows/acr_tomcat_README_md.yml) | ![acr/tomcat/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/tomcat/README.md/badge.svg)
| 10. [Push a WildFly Docker image](acr/wildfly/) | [Workflow](.github/workflows/acr_wildfly_README_md.yml) | ![acr/wildfly/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/acr/wildfly/README.md/badge.svg)

## Azure Cosmos DB examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Create an Azure Cosmos DB](cosmosdb/create/) | [Workflow](.github/workflows/cosmosdb_create_README_md.yml) | [![cosmosdb/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create_README_md.yml)

## Azure Database for MySQL examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Deploy an Azure Database for MySQL](mysql/create/) | [Workflow](.github/workflows/mysql_create_README_md.yml) | [![mysql/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_create_README_md.yml)
| 2. [Open MySQL server firewall to your IP address](mysql/open-firewall-to-your-ip/) | [Workflows](.github/workflows/mysql_open-firewall-to-your-ip_README_md.yml) | [![mysql/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_open-firewall-to-your-ip_README_md.yml)
| 3. [Load your MySQL database with data](mysql/load-your-mysql-database-with-data/) | [Workflows](.github/workflows/mysql_load-your-mysql-database-with-data_README_md.yml) | [![mysql/load-your-mysql-database-with-data/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_load-your-mysql-database-with-data_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_load-your-mysql-database-with-data_README_md.yml)

## Azure Functions examples

1. [Install Azure Functions Core Tools](functions/install-tools/)
1. [Deploy a Java Function](functions/java/)
1. [Deploy a Cosmos DB output Function](functions/cosmosdb-output/)

## Azure Key Vault examples

1. [Create an Azure Key Vault](keyvault/create/)
1. [Add a Secret to an Azure Key Vault](keyvault/add-secret/)
1. [Create a self-signed certificate](keyvault/create-self-signed-certificate/)
1. [Create a Spring Boot application with server-side mTLS](keyvault/spring-boot-mtls-server-side/)
1. [Create a Spring Boot application with client-side mTLS](keyvault/spring-boot-mtls-client-side/)
1. [Create a server-side SSL Spring Boot application](keyvault/spring-boot-ssl-server-side/)

## Azure Kubernetes Service examples

1. [Create an Azure Kubernetes Service cluster](aks/create/)
1. [Create a Kube config file using admin access](aks/create-kube-config/)
1. [Update your cluster to use your Azure Container Registry](aks/use-your-acr/)
1. [Deploy a Spring Boot application](aks/springboot/)
1. [Deploy Tomcat](aks/tomcat/)
1. [Deploy WildFly](aks/wildfly/)

## Azure Red Hat OpenShift examples

1. [Deploy an Azure Red Hat OpenShift cluster](aro/create/)

## Azure Resource Group examples

|    | Name | Link | Status
| -- | ---- | ---- | ------ 
| 1. | [Create an Azure Resource Group](group/create/) | [Workflow](.github/workflows/group_create_README_md.yml) | ![group/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/group/create/README.md/badge.svg)
| 2. | [Delete an Azure Resource Group](group/delete/) | [Workflow](.github/workflows/group_delete_README_md.yml) | ![group/delete/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/group/delete/README.md/badge.svg)

## Azure Service Bus examples

1. [Create an Azure Service Bus](servicebus/create/)
1. [Create an Azure Service Bus Queue](servicebus/create-queue/)
1. [Send a message](servicebus/send-message/)
1. [Receive a message](servicebus/receive-message/)
1. [Send a JMS message](servicebus/send-jms-message/)
1. [Receive a JMS message](servicebus/receive-jms-message/)

## Azure Spring Cloud examples

1. [Create an Azure Spring Cloud](spring-cloud/create/)
1. [Deploy a Spring Boot application to Azure Spring Cloud](spring-cloud/helloworld/)
1. [Configure the Azure Spring Cloud Config Server](spring-cloud/config-server/)

## Azure Storage examples

1. [Create an Azure Storage Account](storage/create/)
1. [Enabled static website hosting on Azure Storage](storage/enable-static-website-hosting/)
1. [Upload files to static website](storage/blob/upload-files-to-static-website/)
