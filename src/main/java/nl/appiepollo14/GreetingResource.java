package nl.appiepollo14;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
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
    Tracer tracer;

    @Inject
    Blabla blabla;

    @GET
    @NonBlocking
    public String start() {
        System.out.println("OTEL context in REST API" + Context.current());
        bus.send("topic", new Request(Context.current()));
        return "Hello from Quarkus REST";
    }

    @Blocking
    @ConsumeEvent("topic")
    public void processing(Request r) throws InterruptedException {
        Span span = tracer.spanBuilder("My custom span")
                .setAttribute("attr", "attr.value")
                .setParent(r.c())
                .setSpanKind(SpanKind.INTERNAL)
                .startSpan();

        // traced work
        System.out.println("Processing");
        blabla.waiter(r.c());

        span.end();
        System.out.println("Finished");
    }
}
