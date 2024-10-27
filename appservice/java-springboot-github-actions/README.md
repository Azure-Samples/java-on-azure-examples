
# Deploy a Spring Boot Application using Github Actions

## Prerequisites

This example assumes you have previously completed the following examples:

1. [Create an Azure Resource Group](../../group/create/README.md)
1. [Create an Azure App Service Plan](../create-plan/README.md)

After that, follow the below steps

1. Click on Resource groups as in the below image

Resource group - It is a container that holds the resources for any Azure solution and is a prerequisite for creating anything on Azure.
![Resource Group](images/ResourceGroup.png)

Click on create and provide a resource-group and then it would be created.
2. Now, click on App Services -> Create -> Web App

    1. Provide the web app name, java version (17/21), operating system (Windows/Linux), region (US/India) etc.

    2. Then click on "Review+Create" at the bottom.

       This is how the newly created app service would look like

![App Service](images/AppService.png)


3. Create a Spring Boot application with help of https://start.spring.io


4. Then create a rest controller like below

```
   @RestController
   public class SpringAzureApplication {

   @GetMapping("/message")
   public String message(){
   return "Azure deployment is working";
   }
}
```
5. Execute the below git commands and push local code to github branch
```
git remote add origin <repository_url> (repository url indicates the newly created github repository)

git add .  (to add all the changes done in local)

git commit -m "First commit"    (does the commit with a message)

git push -u origin master     (push all the changes to github repository)
```
6. Click on Deployment centre
   ![Deployment Centre](images/DeploymentCentre.png)


- In the source dropdown, select Github and Authorise which would ask for the username and password.

- After that, select the organization, repository, branch as well in the dropdown.

- You can click on the "Preview file" to see what steps would be performed as part of the build and deploy process

![Preview File](images/PreviewFile.png)

7. Click on save


8. The build will start & complete after which the deployment will start and succeed.


9. Users can test the application with the help of URL (will be present in Github Actions tab) which would look something like http://spring-azure-demo.azurewebsites.net and need to append "message" at the end because that was defined in the RestController.

    - Upon successful hit of the URL, should get a message like  "Azure deployment is working" which was given in the GetMapping method. 
