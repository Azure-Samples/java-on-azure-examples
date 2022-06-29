package examples.azure.containers.acr.dropwizard;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/helloworld")
@Produces(APPLICATION_JSON)
public class HelloWorldResource {

    @GET
    public String hello() {
        return "Hello World";
    }
}
