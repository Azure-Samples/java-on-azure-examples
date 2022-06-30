package helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloWorldApplication {

    public static void main(String[] arguments) {
        SpringApplication.run(HelloWorldApplication.class, arguments);
    }
}
