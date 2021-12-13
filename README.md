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
| 15. [Deploy a managed JavaSE Quarkus application](appservice/javase-quarkus/) | [Workflow](.github/workflows/appservice_javase-quarkus_README_md.yml) | [![appservice/javase-quarkus/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_javase-quarkus_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_javase-quarkus_README_md.yml)
| 16. [Deploy a GraalVM application using a Docker image](appservice/docker-graalvm/) | [Workflow](.github/workflows/appservice_docker-graalvm_README_md.yml) | [![appservice/docker-graalvm/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-graalvm_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_docker-graalvm_README_md.yml)
| 17. [Swap a deployment slot](appservice/swap-deployment-slot/) | [Workflow](.github/workflows/appservice_swap-deployment-slot_README_md.yml) | [![appservice/swap-deployment-slot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_swap-deployment-slot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_swap-deployment-slot_README_md.yml)
| 18. [Deploy a web application on a managed JBoss EAP](appservice/jboss-eap-helloworld/) | [Workflow](.github/workflows/appservice_jboss-eap-helloworld_README_md.yml) | [![appservice/jboss-eap-helloworld/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_jboss-eap-helloworld_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/appservice_jboss-eap-helloworld_README_md.yml)

## Azure Cache for Redis examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Create an Azure Cache for Redis](redis/create/README.md) | [Workflow](.github/workflows/redis_create_README_md.yml) | ![redis/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/redis/create/README.md/badge.svg)

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
| 2. [Create a SQL database](cosmosdb/create-sql-database/) | [Workflow](.github/workflows/cosmosdb_create-sql-database_README_md.yml) | [![cosmosdb/create-sql-database/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-database_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-database_README_md.yml)
| 3. [Create a SQL container](cosmosdb/create-sql-container/) | [Workflow](.github/workflows/cosmosdb_create-sql-container_README_md.yml) | [![cosmosdb/create-sql-container/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-container_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-container_README_md.yml)
| 4. [Insert item into a SQL container](cosmosdb/insert-item-into-sql-container/) | [Workflow](.github/workflows/cosmosdb_insert-item-into-sql-container_README_md.yml) | [![cosmosdb/insert-item-into-sql-container/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_insert-item-into-sql-container_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_insert-item-into-sql-container_README_md.yml)
| 5. [Create SQL leases container](cosmosdb/create-sql-leases-container/) | [Workflow](.github/workflows/cosmosdb_create-sql-leases-container_README_md.yml) | [![cosmosdb/create-sql-leases-container/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-leases-container_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_create-sql-leases-container_README_md.yml)
| 6. [SQL Change Feed Processor](cosmosdb/sql-change-feed-processor/) | [Workflow](.github/workflows/cosmosdb_sql-change-feed-processor_README_md.yml) | [![cosmosdb/sql-change-feed-processor/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_sql-change-feed-processor_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/cosmosdb_sql-change-feed-processor_README_md.yml)

## Azure Data Explorer examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Create an Azure Data Explorer cluster](adx/create/README.md) | [Workflow](.github/workflows/adx_create_README_md.yml) | ![adx/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/adx/create/README.md/badge.svg)
| 2. [Create a database](adx/create-database/README.md) | [Workflow](.github/workflows/adx_create-database_README_md.yml) | ![adx/create-database/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/adx/create-database/README.md/badge.svg)
| 3. [Create a table](adx/create-table/README.md) | |
| 4. [Ingest Client](adx/ingest-client/README.md) | |

## Azure Database for MySQL examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Deploy an Azure Database for MySQL](mysql/create/) | [Workflow](.github/workflows/mysql_create_README_md.yml) | [![mysql/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_create_README_md.yml)
| 2. [Open MySQL server firewall to your IP address](mysql/open-firewall-to-your-ip/) | [Workflow](.github/workflows/mysql_open-firewall-to-your-ip_README_md.yml) | [![mysql/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_open-firewall-to-your-ip_README_md.yml)
| 3. [Load your MySQL database with data](mysql/load-your-mysql-database-with-data/) | [Workflow](.github/workflows/mysql_load-your-mysql-database-with-data_README_md.yml) | [![mysql/load-your-mysql-database-with-data/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_load-your-mysql-database-with-data_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_load-your-mysql-database-with-data_README_md.yml)
| 4. [Get country information (JDBC client)](mysql/get-country/) | [Workflow](.github/workflows/mysql_get-country_README_md.yml) | [![mysql/get-country/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_get-country_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mysql_get-country_README_md.yml)

## Azure Database for PostgreSQL examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Deploy an Azure Database for PostgreSQL](postgresql/create/) | [Workflow](.github/workflows/postgresql_create_README_md.yml) | [![postgresql/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_create_README_md.yml)
| 2. [Open PostgreSQL server firewall to your IP address](postgresql/open-firewall-to-your-ip/) | [Workflow](.github/workflows/postgresql_open-firewall-to-your-ip_README_md.yml) | [![postgresql/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_open-firewall-to-your-ip_README_md.yml)
| 3. [Load your PostgreSQL database with data](postgresql/load-your-postgresql-database-with-data/) | [Workflow](.github/workflows/postgresql_load-your-postgresql-database-with-data_README_md.yml) | [![postgresql/load-your-postgresql-database-with-data/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_load-your-postgresql-database-with-data_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_load-your-postgresql-database-with-data_README_md.yml)
| 4. [Get country information (JDBC client)](postgresql/get-country/) | [Workflow](.github/workflows/postgresql_get-country_README_md.yml) | [![postgresql/get-country/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_get-country_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/postgresql_get-country_README_md.yml)

## Azure Event Hubs examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Create a namespace](eventhubs/create-namespace/README.md) | [Workflow](.github/workflows/eventhubs_create-namespace_README_md.yml) | [![eventhubs/create-namespace/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_create-namespace_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_create-namespace_README_md.yml)
| 2. [Create an event hub](eventhubs/create-eventhub/README.md) | [Workflow](.github/workflows/eventhubs_create-eventhub_README_md.yml) |  [![eventhubs/create-eventhub/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_create-eventhub_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_create-eventhub_README_md.yml)
| 3. [Send an event](eventhubs/send-event/README.md) | [Workflow](.github/workflows/eventhubs_send-event_README_md.yml) | [![eventhubs/send-event/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_send-event_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_send-event_README_md.yml)
| 4. [Receive an event](eventhubs/receive-event/README.md) | [Workflow](.github/workflows/eventhubs_receive-event_README_md.yml) |  [![eventhubs/receive-event/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_receive-event_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/eventhubs_receive-event_README_md.yml)

## Azure Functions examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Install Azure Functions Core Tools](functions/install-tools/) | [Workflow](.github/workflows/functions_install-tools_README_md.yml) | [![functions/install-tools/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functions_install-tools_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functions_install-tools_README_md.yml)
| 2. [Deploy a Java Function](functions/java/) | [Workflow](.github/workflows/functions_java_README_md.yml) | [![functions/java/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functions_java_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functions_java_README_md.yml)
| 3. [Deploy a Cosmos DB output Function](functions/cosmosdb-output/) | [Workflow](.github/workflows/functions_cosmosdb-output_README_md.yml) | [![functions/cosmosdb-output/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functions_cosmosdb-output_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/functions_cosmosdb-output_README_md.yml)

## Azure Key Vault examples

| Name | Status
| ---- | ------
| 1. [Create an Azure Key Vault](keyvault/create/README.md) | ![keyvault/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/keyvault/create/README.md/badge.svg)
| 2. [Add a Secret](keyvault/add-secret/README.md)          | ![keyvault/add-secret/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/keyvault/add-secret/README.md/badge.svg)

1. [Create a self-signed certificate](keyvault/create-self-signed-certificate/)
1. [Create a Spring Boot application with server-side mTLS](keyvault/spring-boot-mtls-server-side/)
1. [Create a Spring Boot application with client-side mTLS](keyvault/spring-boot-mtls-client-side/)
1. [Create a server-side SSL Spring Boot application](keyvault/spring-boot-ssl-server-side/)

## Azure Kubernetes Service examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Create an Azure Kubernetes Service cluster](aks/create/) | [Workflow](.github/workflows/aks_create_README_md.yml) | [![aks/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_create_README_md.yml)
| 2. [Create a Kube config file using admin access](aks/create-kube-config/) | [Workflow](.github/workflows/aks_create-kube-config_README_md.yml) | [![aks/create-kube-config/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_create-kube-config_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_create-kube-config_README_md.yml)
| 3. [Update your cluster to use your Azure Container Registry](aks/use-your-acr/) | [Workflow](.github/workflows/aks_use-your-acr_README_md.yml) | [![aks/use-your-acr/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_use-your-acr_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_use-your-acr_README_md.yml)
| 4. [Deploy a Spring Boot application](aks/springboot/) | [Workflow](.github/workflows/aks_springboot_README_md.yml) | [![aks/springboot/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_springboot_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_springboot_README_md.yml)
| 5. [Deploy Tomcat](aks/tomcat/) | [Workflow](.github/workflows/aks_tomcat_README_md.yml) | [![aks/tomcat/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_tomcat_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_tomcat_README_md.yml)
| 6. [Deploy WildFly](aks/wildfly/) | [Workflow](.github/workflows/aks_wildfly_README_md.yml) | [![aks/wildfly/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_wildfly_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/aks_wildfly_README_md.yml)

## Azure Red Hat OpenShift examples

1. [Deploy an Azure Red Hat OpenShift cluster](aro/create/)

## Azure Resource Group examples

| Name | Link | Status
| ---- | ---- | ------ 
| 1. [Create an Azure Resource Group](group/create/) | [Workflow](.github/workflows/group_create_README_md.yml) | ![group/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/group/create/README.md/badge.svg)
| 2. [Delete an Azure Resource Group](group/delete/) | [Workflow](.github/workflows/group_delete_README_md.yml) | ![group/delete/README.md](https://github.com/Azure-Samples/java-on-azure-examples/workflows/group/delete/README.md/badge.svg)

## Azure Service Bus examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Create an Azure Service Bus](servicebus/create/) | [Workflow](.github/workflows/servicebus_create_README_md.yml)  | [![servicebus/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_create_README_md.yml)
| 2. [Create an Azure Service Bus Queue](servicebus/create-queue/) | [Workflow](.github/workflows/servicebus_create-queue_README_md.yml) | [![servicebus/create-queue/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_create-queue_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_create-queue_README_md.yml)
| 3. [Send a message](servicebus/send-message/) | [Workflow](.github/workflows/servicebus_send-message_README_md.yml) | [![servicebus/send-message/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_send-message_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_send-message_README_md.yml)
| 4. [Receive a message](servicebus/receive-message/) | [Workflow](.github/workflows/servicebus_receive-message_README_md.yml) | [![servicebus/receive-message/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_receive-message_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_receive-message_README_md.yml)
| 5. [Send a JMS message](servicebus/send-jms-message/) | [Workflow](.github/workflows/servicebus_send-jms-message_README_md.yml) | [![servicebus/send-jms-message/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_send-jms-message_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_send-jms-message_README_md.yml)
| 6. [Receive a JMS message](servicebus/receive-jms-message/) | [Workflow](.github/workflows/servicebus_receive-jms-message_README_md.yml) | [![servicebus/receive-jms-message/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_receive-jms-message_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/servicebus_receive-jms-message_README_md.yml)

## Azure Spring Cloud examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Create an Azure Spring Cloud](spring-cloud/create/) | [Workflow](.github/workflows/spring-cloud_create_README_md.yml) | [![spring-cloud/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring-cloud_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring-cloud_create_README_md.yml)
| 2. [Deploy a Spring Boot application to Azure Spring Cloud](spring-cloud/helloworld/) | [Workflow](.github/workflows/spring-cloud_helloworld_README_md.yml) | [![spring-cloud/helloworld/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring-cloud_helloworld_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring-cloud_helloworld_README_md.yml)
| 3. [Configure the Azure Spring Cloud Config Server](spring-cloud/config-server/) | [Workflow](.github/workflows/spring-cloud_config-server_README_md.yml) | [![spring-cloud/config-server/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring-cloud_config-server_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/spring-cloud_config-server_README_md.yml)

## Azure SQL Database examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Deploy an Azure SQL Database](mssql/create/) | [Workflow](.github/workflows/mssql_create_README_md.yml) | [![mssql/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_create_README_md.yml)
| 2. [Open Azure SQL server firewall to your IP address](mssql/open-firewall-to-your-ip/) | [Workflow](.github/workflows/mssql_open-firewall-to-your-ip_README_md.yml) | [![mssql/open-firewall-to-your-ip/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_open-firewall-to-your-ip_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_open-firewall-to-your-ip_README_md.yml)
| 3. [Load your Azure SQL database with data](mssql/load-your-mssql-database-with-data/) | [Workflow](.github/workflows/mssql_load-your-mssql-database-with-data_README_md.yml) | [![mssql/load-your-mssql-database-with-data/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_load-your-mssql-database-with-data_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_load-your-mssql-database-with-data_README_md.yml)
| 4. [Get country information (JDBC client)](mssql/get-country/) | [Workflow](.github/workflows/mssql_get-country_README_md.yml) | [![mssql/get-country/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_get-country_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/mssql_get-country_README_md.yml)

## Azure Storage examples

| Name | Link | Status
| ---- | ---- | ------
| 1. [Create an Azure Storage Account](storage/create/) | [Workflow](.github/workflows/storage_create_README_md.yml) | [![storage/create/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_create_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_create_README_md.yml)
| 2. [Enabled static website hosting](storage/enable-static-website/) | [Workflow](.github/workflows/storage_enable-static-website_README_md.yml) | [![storage/enable-static-website/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_enable-static-website_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_enable-static-website_README_md.yml)
| 3. [Upload files to static website](storage/upload-files-to-static-website/) | [Workflow](.github/workflows/storage_upload-files-to-static-website_README_md.yml) | [![storage/upload-files-to-static-website/README.md](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_upload-files-to-static-website_README_md.yml/badge.svg)](https://github.com/Azure-Samples/java-on-azure-examples/actions/workflows/storage_upload-files-to-static-website_README_md.yml)
