package com.example;

import static io.micronaut.http.MediaType.TEXT_PLAIN;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/helloworld")
public class HelloWorldController {

    @Get
    @Produces(TEXT_PLAIN)
    public String helloworld() {
        return "Hello World";
    }
}
