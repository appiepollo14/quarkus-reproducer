package nl.appiepollo14;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.vertx.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @Inject
    EventBus bus;

    @Inject
    ProcessingService processingService;

    @POST
    @NonBlocking
    public String start(String body) {
        bus.send("topic", body);
        return "Hello from Quarkus REST";
    }

    @Blocking
    @ConsumeEvent("topic")
    public void processing(String body) {
        processingService.start(body);
    }
}
