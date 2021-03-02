package com.endava.example.metrics;

import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Component
public class MyComponent {

    private final Counter myCounter;

    public MyComponent(MeterRegistry registry) {
        myCounter = Counter.builder("mycustomcounter").description("this is my custom counter").register(registry);
    }

    public void countedCall() {
        myCounter.increment();
    }
}
