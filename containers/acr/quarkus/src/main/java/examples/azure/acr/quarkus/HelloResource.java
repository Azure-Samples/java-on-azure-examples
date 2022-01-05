package examples.azure.acr.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloResource {

    @GET
    @Produces({MediaType.TEXT_HTML, MediaType.TEXT_PLAIN})
    public String hello() {
        return "hello";
    }
}