# Spring boot Azure Cache for Redis Example
This application serves as an example of how to call Azure Cache for Redis using a private endpoint from a Spring Boot application
## Maven dependencies for Redis

```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
```

## Spring properties

```
spring.redis.host=<rediscaheName>.redis.cache.windows.net
spring.redis.port=6380
spring.redis.password=<redis access key>
spring.redis.ssl=true

```

## Endpoints

- POST : /product/add : Adds A product that will be stored in Azure cache for Redis
  jsonBody:
  ```json
	{
    "id": "4",
    "name": "tajine"
	}
  ```
- GET : /product/{id} : Gets the product by id from Azure Cache for Redis
- GET : /products : Gets the list of the products stored in Azure Cache for Redis

## Test From Postman

To call the endpoitns bellow you can import the postman collection loocated in the folder /postman

## Configure Azure Cache for Redis with private endpoint 

- [Azure Cache for Redis with Azure Private Link](https://learn.microsoft.com/en-us/azure/azure-cache-for-redis/cache-private-link)

## Note 

ApplicationS should connect to {cachename}.redis.cache.windows.net on port 6380. Microsoft recommends avoiding the use of {cachename}.privatelink.redis.cache.windows.net in configuration or connection string.