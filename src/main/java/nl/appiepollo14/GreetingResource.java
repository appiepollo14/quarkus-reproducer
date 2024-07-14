package nl.appiepollo14;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "api-key")
    String apikey;

    @GET
    public String returnConfigProperty() {
        return apikey;
    }
}
