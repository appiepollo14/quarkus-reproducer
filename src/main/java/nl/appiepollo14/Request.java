package nl.appiepollo14;

import io.opentelemetry.context.Context;

public record Request(Context c) {
}