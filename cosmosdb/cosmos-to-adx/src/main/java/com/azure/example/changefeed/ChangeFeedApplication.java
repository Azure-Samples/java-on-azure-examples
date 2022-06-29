package com.azure.example.changefeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The ChangeFeed Spring Boot application.
 */
@SpringBootApplication
public class ChangeFeedApplication {

    /**
     * The main method.
     *
     * @param arguments the arguments.
     */
    public static void main(String[] arguments) {
        SpringApplication.run(ChangeFeedApplication.class, arguments);
    }
}
