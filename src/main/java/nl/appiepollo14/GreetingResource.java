package nl.appiepollo14;

import io.opentelemetry.context.Context;
import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.common.annotation.NonBlocking;
import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @Inject
    EventBus bus;

    @GET
    @NonBlocking
    public String start() {
        System.out.println("OTEL context in REST API" + Context.current());
        bus.send("topic", "dummyBody");
        return "Hello from Quarkus REST";
    }

    @Blocking
    @ConsumeEvent("topic")
    public void processing(String body) {
        System.out.println("OTEL context in eventbus: " + Context.current());
        System.out.println("Processing");
    }
}
