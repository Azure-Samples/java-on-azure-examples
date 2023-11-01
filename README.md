# Java on Azure Examples

This GitHub repository contains a set of Azure examples specifically for Java developers to quickly get started with Azure.
Please use the issue tracker to leave feedback, file issues or to propose other examples.

## Getting started

To work with these examples it is assumed you have the Azure CLI installed, and you have logged in and set your default subscription.
If you haven't done so follow the steps below.

_Note: Logging in and setting your default subscription needs to be done once per terminal session._

### Install Azure CLI

To setup the Azure CLI, please visit [Install the Azure CLI](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli).
And once you are done come back to this README.

### Login into Azure

<!-- workflow.skip() -->
````shell
  az login
````

### Set your default subscription

Get a list of your subscriptions (notice the `refresh` parameter that retrieves up-to-date subscriptions from the server) :

<!-- workflow.skip() -->
````shell
  az account list --output table --refresh
````

Set your default subscription for this session using the subscription id from the previous output:

<!-- workflow.skip() -->
````shell
  az account set --subscription "subscription-id"
````

<!-- workflow.run() 

  exit 0

  -->

## Our alphabetical list of examples

1. [Azure App Configuration examples](appconfig/)
1. [Azure App Service examples](appservice/)      
1. [Azure Cache for Redis examples](redis/)            <!-- workflows run Sunday    / 2 examples  -->
1. [Azure Cognitive Services examples](cognitiveservices/)
1. [Azure Container Apps examples](containerapp/)
1. [Azure Container Instances examples](container/)
1. [Azure Container Registry examples](acr/)
1. [Azure Cosmos DB examples](cosmosdb/)
1. [Azure Front Door examples](afd/)
1. [Azure Data Explorer examples](kusto/)              <!-- workflows run Sunday    / 4 examples  -->
1. [Azure Database for MySQL examples](mysql/)         <!-- workflows run Tuesday   / 4 examples  -->
1. [Azure Database for PostgreSQL examples](postgres/) <!-- workflows run Monday    / 4 examples  -->
1. [Azure Event Hubs examples](eventhubs/)             <!-- workflows run Saturday  / 4 examples  -->
1. [Azure Functions examples](functionapp/)            <!-- workflows run Thursday  / 3 examples  -->
1. [Azure Key Vault examples](keyvault/)               <!-- workflows run Tuesday   / 6 examples  -->
1. [Azure Kubernetes Service examples](aks/)           
1. [Azure Monitor examples](monitor/)                  <!-- workflows run Thursday  / 1 example   -->
1. [Azure Networking examples](network/)               <!-- workflows run Wednesday / 1 example   -->
1. [Azure Red Hat OpenShift examples](aro/)
1. [Azure Resource Group examples](group/)             <!-- workflows run Saturday  / 2 examples  -->
1. [Azure Service Bus examples](servicebus/)           <!-- workflows run Friday    / 9 examples  -->
1. [Azure Spring Apps examples](spring/)               <!-- workflows run Wednesday / 3 examples  -->
1. [Azure SQL Database examples](sql/)                 <!-- workflows run Wednesday / 4 examples  -->
1. [Azure Storage examples](storage/)                  <!-- workflows run Monday    / 3 examples  -->

## Contributing

How do I contribute? See [Contributing](CONTRIBUTING.md)

<!-- 

  Azure Container Registry examples

   1. acr/create/README.md                                                  - 0  0 * * 1 - westus
   2. acr/create-acrpull-service-principal/README.md                        - 0  1 * * 1 - westus
   3. acr/create-settings-xml/README.md                                     - 0  2 * * 1 - westus
   4. acr/dropwizard/README.md                                              - 0  3 * * 1 - westus
   5. acr/glassfish/README.md                                               - 0  4 * * 1 - westus
   6. acr/graalvm/README.md                                                 - 0  5 * * 1 - westus
   7. acr/helidon/README.md                                                 - 0  6 * * 1 - westus
   8. acr/helloworldjob/README.md                                           - 0  7 * * 1 - westus
   9. acr/jetty/README.md                                                   - 0  8 * * 1 - westus
  10. acr/micronaut/README.md                                               - 0  9 * * 1 - westus
  11. acr/payara/READNE.md                                                  - 0 10 * * 1 - westus
  12. acr/piranha/README.md                                                 - 0 11 * * 1 - westus
  13. acr/quarkus/README.md                                                 - 0 12 * * 1 - westus
  14. acr/springboot/README.md                                              - 0 13 * * 1 - westus
  15. acr/tomcat/README.md                                                  - 0 14 * * 1 - westus
  16. acr/wildfly/README.md                                                 - 0 15 * * 1 - westus

Azure Front Door examples

  1. afd/add-origins-to-origin-group/README.md                              - 0 16 * * 1 - westus
  2. afd/add-route/README.md                                                - 0 17 * * 1 - westus
  3. afd/create-endpoint/README.md                                          - 0 18 * * 1 - westus
  4. afd/create-origin-group/README.md                                      - 0 19 * * 1 - westus
  5. afd/create-profile/README.md                                           - 0 20 * * 1 - westus

Azure Kubernetes Service examples

  1. aks/create/README.md                                                   - 0 21 * * 1 - westus
  2. aks/create-kube-config/README.md                                       - 0 22 * * 1 - westus
  3. aks/graalvm/README.md                                                  - 0 23 * * 1 - westus
  4. aks/springboot/README.md                                               - 0  0 * * 2 - westus
  5. aks/tomcat/README.md                                                   - 0  1 * * 2 - westus
  6. aks/use-your-acr/README.md                                             - 0  2 * * 2 - westus
  7. aks/wildfly/README.md                                                  - 0  3 * * 2 - westus

Azure App Configuration examples

  1. appconfig/add-key-value/README.md                                      - 0  4 * * 2 - westus
  2. appconfig/create/README.md                                             - 0  5 * * 2 - westus

Azure App Service examples

  1. appservice/container-glassfish/README.md                               - 0  6 * * 2 - westus
  2. appservice/container-graalvm/README.md                                 - 0  7 * * 2 - westus
  3. appservice/container-jetty/README.md                                   - 0  8 * * 2 - westus
  4. appservice/container-payara/README.md                                  - 0  9 * * 2 - westus
  5. appservice/create-deployment-slot/README.md                            - 0 10 * * 2 - westus
  6. appservice/create-plan/README.md                                       - 0 11 * * 2 - westus
  7. appservice/delete-plan/README.md                                       - 0 12 * * 2 - westus
  8. appservice/delete-webapp/README.md                                     - 0 13 * * 2 - westus
  9. appservice/deploy-to-deployment-slot/README.md                         - 0 14 * * 2 - westus
 10. appservice/docker-tomcat/README.md                                     - 0 15 * * 2 - westus
 11. appservice/docker-wildfly/README.md                                    - 0 16 * * 2 - westus
 12. appservice/javase-quarkus/README.md                                    - 0 17 * * 2 - westus
 13. appservice/javase-springboot/README.md                                 - 0 18 * * 2 - westus
 14. appservice/jboss-eap-helloworld/README.md                              - 0 19 * * 2 - westus
 15. appservice/list-webapp/README.md                                       - 0 20 * * 2 - westus
 16. appservice/scale-manually/README.md                                    - 0 21 * * 2 - westus
 17. appservice/swap-deployment-slot/README.md                              - 0 22 * * 2 - westus
 18. appservice/tomcat-helloworld/README.md                                 - 0 23 * * 2 - westus

Azure Container Instances examples

  1. container/quarkus/README.md                                            - 0  0 * * 3 - westus
  2. container/tomcat/README.md                                             - 0  1 * * 3 - westus
  3. container/wildfly/README.md                                            - 0  2 * * 3 - westus

Azure Container Apps examples

  1. containerapp/create-environment/README.md                              - 0  3 * * 3 - westus
  2. containerapp/create-manual-job/README.md                               - 0  4 * * 3 - westus
  3. containerapp/dropwizard/README.md                                      - 0  5 * * 3 - westus
  4. containerapp/execute-manual-job/README.md                              - 0  6 * * 3 - westus
  5. containerapp/get-job-execution-log/README.md                           - 0  7 * * 3 - westus
  6. containerapp/glassfish/README.md                                       - 0  8 * * 3 - westus
  7. containerapp/helidon/README.md                                         - 0  9 * * 3 - westus
  8. containerapp/list-job-executions/README.md                             - 0 10 * * 3 - westus
  9. containerapp/micronaut/README.md                                       - 0 11 * * 3 - westus
 10. containerapp/piranha/README.md                                         - 0 12 * * 3 - westus
 11. containerapp/quarkus/README.md                                         - 0 13 * * 3 - westus
 12. containerapp/springboot/README.md                                      - 0 14 * * 3 - westus
 13. containerapp/tomcat/README.md                                          - 0 15 * * 3 - westus
 14. containerapp/wildfly/README.md                                         - 0 16 * * 3 - westus

Azure Cosmos DB examples

  1. cosmosdb/create/README.md                                              - 0 17 * * 3 - westus
  2. cosmosdb/create-sql-container/README.md                                - 0 18 * * 3 - westus
  3. cosmosdb/create-sql-database/README.md                                 - 0 19 * * 3 - westus
  4. cosmosdb/create-sql-leases-container/README.md                         - 0 20 * * 3 - westus
  5. cosmosdb/insert-item-into-sql-container/README.md                      - 0 21 * * 3 - westus
  6. cosmosdb/sql-change-feed-processor/README.md                           - 0 22 * * 3 - westus

Azure Event Hubs examples

  1. eventhubs/create-eventhub/README.md                                    - 0 23 * * 3 - westus
  2. eventhubs/create-namespace/README.md                                   - 0  0 * * 4 - westus
  3. eventhubs/receive-event/README.md                                      - 0  1 * * 4 - westus
  4. eventhubs/send-event/README.md                                         - 0  2 * * 4 - westus

Azure Functions examples

  1. functionapp/cosmosdb-output/README.md                                  - 0  3 * * 4 - westus3
  2. functionapp/helloworld/README.md                                       - 0  4 * * 4 - westus3
  3. functionapp/install-tools/README.md                                    - 0  5 * * 4 - westus3

Azure Resource Group examples

  1. group/create/README.md                                                 - 0  6 * * 4 - westus
  2. group/delete/README.md                                                 - 0  7 * * 4 - westus

Azure Key Vault examples

  1. keyvault/add-secret/README.md                                          - 0  8 * * 4 - westus
  2. keyvault/create/README.md                                              - 0  9 * * 4 - westus
  3. keyvault/create-self-signed-certificate/README.md                      - 0 10 * * 4 - westus

Azure Data Explorer examples

  1. kusto/create/README.md                                                 - 0 11 * * 4 - westus
  2. kusto/create-database/README.md                                        - 0 12 * * 4 - westus

Azure Monitor examples

  1. monitor/create-log-analytics-workspace/README.md                       - 0 13 * * 4 - westus

Azure Database for MySQL examples

  1. mysql/create/README.md                                                 - 0 14 * * 4 - westus
  2. mysql/get-country/README.md                                            - 0 15 * * 4 - westus
  3. mysql/load-your-mysql-database-with-data/README.md                     - 0 16 * * 4 - westus

Azure Cognitive Services examples

  1. cognitiveservices/create-openai-account/README.md                      - 0 17 * * 4 - eastus
  2. cognitiveservices/create-gpt35-model/README.md                         - 0 18 * * 4 - eastus
  3. cognitiveservices/chat-with-semantic-kernel-and-gpt35/README.md        - 0 19 * * 4 - eastus

Azure SQL Database examples

  1. sql/create/README.md                                                   - 0 20 * * 4 - westus2
  2. sql/get-country/README.md                                              - 0 21 * * 4 - westus2
  3. sql/load-your-mssql-database-with-data/README.md                       - 0 22 * * 4 - westus2
  4. sql/open-firewall-to-your-ip/README.md                                 - 0 23 * * 4 - westus2

 -->
