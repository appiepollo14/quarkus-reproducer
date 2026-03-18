package nl.appiepollo14;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    SshSessionFactory sshSessionFactory;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "SSH Session Factory: " + sshSessionFactory.getClass().getSimpleName();
    }
}
