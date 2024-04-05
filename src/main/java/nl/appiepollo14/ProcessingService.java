package nl.appiepollo14;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.rmi.NotBoundException;

@ApplicationScoped
public class ProcessingService {

    @Inject
    @RestClient
    Client clientApi;

    public void start() {
        try {
            task();
        } catch (NotBoundException e) {
            System.out.println("Errorrr");
        }
        try {
            clientApi.get();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Wachtenn...");
    }

    private void task() throws NotBoundException {
        throw new NotBoundException();
    }


}
