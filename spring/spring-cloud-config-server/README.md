# Setting Up Azure Spring Cloud Config Server for Centralized Configuration in Spring Boot

## Prerequisites

This example assumes you have previously completed the following examples:

[Create an Azure Resource Group](https://github.com/Azure-Samples/java-on-azure-examples/blob/main/group/create/README.md)
[Create an Azure Spring Apps environment](https://github.com/Azure-Samples/java-on-azure-examples/blob/main/spring/create/README.md)

## Create an Azure Spring Cloud Config Server 
This guide demonstrates how to set up an Azure Spring Cloud Config Server for managing application configurations across multiple Spring Boot services. We'll use a Git repository for storing configuration files and build a simple Customer service with a Controller, Service, and Repository layer.

1. Create Configuration in a <b>Git Repository</b>

*  Create a Git repository (e.g., spring-config-repo) to store configurations.
*  Add application.yml for shared configuration and application-dev.yml for environment-specific values.

## Create a Spring Boot Application

1. On the other side, create a Spring Boot application with help of https://start.spring.io

2. Open the project in the IDE and then create the below classes

i. An application yaml file

```
spring:
application:
name: customer-service
datasource:
url: jdbc:mysql://localhost:3306/customerdb
username: ${DB_USER}
password: ${DB_PASS}`
```

ii. Application dev yaml file
spring:
datasource:
url: jdbc:mysql://dev-db-server:3306/customerdb
username: ${DB_USER_DEV}
password: ${DB_PASS_DEV}
cloud:
config:
uri: https://<YOUR_AZURE_CONFIG_SERVER_URL>
label: main
enabled: true

**Note: Sensitive data like database credentials should be securely stored in Azure Key Vault**

3. Add the below dependencies (pom.xml)

```
   <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>
   <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   <dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-config</artifactId>
   </dependency>
   <dependency>
   <groupId>com.microsoft.azure</groupId>
   <artifactId>azure-spring-cloud-dependencies</artifactId>
   <version>2.1.1</version>
   </dependency>`
```

4. Configuration (application.properties in Spring Boot app) 

```
spring.application.name=customer-service 
spring.profiles.active=dev`
```

5. Create Model, Repository, Service, and Controller

```
@Entity
public class Customer {
@Id
@GeneratedValue
private Long id;
private String name;
private String email;
// Getters and setters
}
```

```
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
```


```
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}
```

```
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getAllCustomers();
    }
}
```

6. Configure Azure Spring Cloud with the Config Server

Set up the Config Server to use your Git repository as a configuration source:

```
az spring-cloud config-server set \
    --name <SPRING_CLOUD_APP_NAME> \
    --config-file application-dev.yml \
    --resource-group <RESOURCE_GROUP_NAME>
```
7. Connect Spring Boot to Config Server

The Spring Boot application will use Azure Spring Cloud Config Server to retrieve configuration properties automatically.

## Testing and Deployment
### Testing the Endpoint

After deploying the application, verify it with the following tools and methods:

1. Using cURL, run the following command to test the /api/customers endpoint:
```
curl -X GET http://<APP_URL>/api/customers
```
2. Using Insomnia/Postman
* Open Insomnia or Postman and create a new GET request.
* Set the URL to http://<APP_URL>/api/customers.
* Send the request and check for a JSON response containing customer data.

3. Using Browser
* Navigate to http://<APP_URL>/api/customers in a web browser. The JSON response should be displayed if the API is accessible.

4. Refreshing Configuration
* For real-time configuration updates, you can refresh the Spring Boot application properties without restarting the app. Enable the Spring Boot Actuator refresh endpoint in application.properties:

```
management.endpoints.web.exposure.include=refresh
```

Trigger the refresh by calling the actuator endpoint:
```
curl -X POST http://<APP_URL>/actuator/refresh
```
This command reloads the configuration from the Config Server, applying any updates in the Git repository to the running application.


Cleanup
* To avoid ongoing charges, delete the resources once you are done:
```
az group delete --name <RESOURCE_GROUP_NAME>
```
