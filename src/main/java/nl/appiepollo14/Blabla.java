package nl.appiepollo14;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class Blabla {

    @Inject
    Tracer tracer;

    public void waiter(Context c) throws InterruptedException {
        Span span = tracer.spanBuilder("BLABLA")
                .setAttribute("attr", "attr.value")
                .setParent(c)
                .setSpanKind(SpanKind.INTERNAL)
                .startSpan();
        // Is empty, no context
        System.out.println("Context x " + Context.current());
        Thread.sleep(10000);
        sleeper();
        span.end();
    }

    @WithSpan("SLEEPY")
    public void sleeper() throws InterruptedException {
        // Again no context so this span is not related to parent.
        Thread.sleep(5000);
    }
}
