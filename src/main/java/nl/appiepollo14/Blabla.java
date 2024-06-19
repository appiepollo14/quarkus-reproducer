package nl.appiepollo14;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Blabla {

    @WithSpan("BLABLA")
    public void waiter() throws InterruptedException {
        Thread.sleep(10000);
        sleeper();
    }

    @WithSpan("SLEEPY")
    public void sleeper() throws InterruptedException {
        Thread.sleep(5000);
    }
}
