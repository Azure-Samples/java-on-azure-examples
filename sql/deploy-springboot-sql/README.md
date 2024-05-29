
# Build a SpringBoot Application using Azure SQL and Deploy into Azure

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure SQL Database](../create/README.md)

## Create an Azure SQL DB

This example will create a Spring Boot application which has a couple of endpoints for creating and retrieving employee details. 

1. In the Azure Portal, search for <b>SQL database</b>


2. Click on SQL Database and in the Create SQL Database page

    i. Provide a unique DB name

    ii. Under Server, click new upon which a new page will pop up called as Create SQL Database Server

    iii. Provide a unique Server name and select the location in the dropdown (eg -> (US) East US)

    iv. Under the Authentication -> Authentication method, choose Use SQL authentication (could be Use Microsoft Entra-only authentication as well)

    v. In case of sql authentication, provide below details

   1. Server admin login

   2. Password


3. Leave the other options as such and choose Development as the workload environment


4. Go to the networking tab


5. Under the network connectivity, select Connectivity method as Public endpoint


6. In the firewall rules, Choose "yes" for Allow Azure services and resources to access this server and
Add current client IP address


7. Then click on review and create 


8. This will create a database instance and will get a message "Deployment is completed"
and there would be a button "Go to resource". Upon clicking on that, it will show the sql instance


9. In that, copy the Connection strings (JDBC) and put in application.yml file


10. Provide the username and password (given in the SQL authentication page) in yml file


11. Then go to Set Server Firewall in the SQL instance page and then click on "Add your clinet IPV4 address"


12. Click on <b>Query editor (preview)</b> in the SQL instance page 


13. Enter the username and password (provided as part of sql authentication step in the SQL Server Page)


## Create a Spring Boot Application

1. On the other side, create a Spring Boot application with help of https://start.spring.io


2. Open the project in the IDE and then create the below classes
    
    i. An Employee entity class

```
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String department;
    private long salary;
}
```

ii. An Employee repository class for the DB connection 

```
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
```

iii. A Rest Controller with endpoints to create and retrieve an employee object

```
@SpringBootApplication
@RestController
public class SqlApplication {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> retrieveEmployees() {
        return repository.findAll();
    }

	public static void main(String[] args) {
		SpringApplication.run(SqlApplication.class, args);
	}

}
```
iv. An application.yml file with below properties

```
spring:
  datasource:
    url: <jbdc URL obtained from Step 9 in Create an Azure SQL DB>
    username: <username given in SQL Server page>
    password: <password given in SQL Server page>
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: update
      dialect : org.hibernate.dialect.SQLServer2012Dialect

server:
  port: 8080
```

3. Start the application in the code editor 


4. Then head over to postman client to test the endpoints


5. Select the post request and hit the URL : http://localhost:8080/employee 
and provide a sample json as below in the request body

```
{
"name":"Shiva",
"department":"Chemical",
"salary":25000
}
```

6. If we refresh the Query editor now in Azure SQL DB, dbo.employee table should be listed under the Tables


7. Then enter the query as 
select * from employee would fetch all the employees that were created as part of the postman requests.

Follow the below steps to create an Azure App Service and deploy the Spring Boot application,

1. Click on Resource groups as in the below image

<b>Resource group</b> - It is a container that holds the resources for any Azure solution and is a prerequisite for creating anything on Azure.

https://github.com/karthirm/spring-azure/blob/efa91bd442337ce9b3f69c4cf0193b9837199284/2.%20ResourceGroup.png

Click on create and provide a resource-group and then it would be created.
2. Now, click on App Services -> Create -> Web App

    1. Provide the web app name, java version (17/21), operating system (Windows/Linux), region (US/India) etc.

    2. Then click on "Review+Create" at the bottom.

       This is how the newly created app service would look like

https://github.com/karthirm/spring-azure/blob/main/3.AppService.png

3. Execute the below git commands and push local code to github branch
```
git remote add origin <repository_url> (repository url indicates the newly created github repository)

git add .  (to add all the changes done in local)

git commit -m "First commit"    (does the commit with a message)

git push -u origin master     (push all the changes to github repository)
```

4. Click on <b>Deployment centre</b> as like in the below image

https://github.com/karthirm/spring-azure/blob/main/4.DeploymentCentre.png

- In the source dropdown, select Github and Authorise which would ask for the username and password.

- After that, select the organization, repository, branch as well in the dropdown.

- You can click on the "Preview file" to see what steps would be performed as part of the build and deploy process

https://github.com/karthirm/spring-azure/blob/main/5.PreviewFile.png

5. Click on save


6. The build will start & complete after which the deployment will start and succeed.


Get the URL (should look something like https://springboot-azuresql.azurewebsites.net/employees) from azure app service and append "employees" at the end
to see the list of employees that were created earlier. 


## Cleanup

Do NOT forget to remove the resources once you have completed the entire flow.

