package nl.appiepollo14;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.vertx.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @Inject
    EventBus bus;

    @Inject
    ProcessingService processingService;

    @GET
    @NonBlocking
    public String start() {
        bus.send("topic", "dummyBody");
        return "Hello from Quarkus REST";
    }

    @Blocking
    @ConsumeEvent("topic")
    public void processing(String body) {
        processingService.start();
    }
}
