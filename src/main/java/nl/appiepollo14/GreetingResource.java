package nl.appiepollo14;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.jboss.logging.Logger;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @GET
    public String start() {
        LOG.info("Called hello GET endpoint");
        LOG.error("ERROR");
        return "Hello from Quarkus REST";
    }
}
