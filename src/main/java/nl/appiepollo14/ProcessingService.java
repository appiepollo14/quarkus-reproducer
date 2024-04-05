package nl.appiepollo14;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class ProcessingService {

    @Inject
    @RestClient
    Client clientApi;

    public void start(String body) {
        clientApi.post(body);
    }


}
