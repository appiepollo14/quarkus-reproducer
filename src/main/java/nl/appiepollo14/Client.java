package nl.appiepollo14;

import io.quarkus.rest.client.reactive.ClientExceptionMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/clientApi")
@RegisterRestClient
@ApplicationScoped
public interface Client {

    @GET
    String get();

    @ClientExceptionMapper
    static RuntimeException toException(Response response) {
        if (response.getStatus() == 404) {
            System.out.println("Exception occured!");
        }
        return null;
    }


}
