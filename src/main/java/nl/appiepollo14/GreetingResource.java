package nl.appiepollo14;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;

@Path("/hello")
public class GreetingResource {

    @Inject
    JgitService jgitService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws IOException {
        jgitService.checkout();
        return "Hello from Quarkus REST";
    }
}
