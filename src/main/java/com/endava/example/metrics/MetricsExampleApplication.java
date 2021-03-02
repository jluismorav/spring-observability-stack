package com.endava.example.metrics;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;

@SpringBootApplication
public class MetricsExampleApplication {

	@Bean
	public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
		return registry -> {
			try {
				registry.config().commonTags("application", InetAddress.getLocalHost().getHostName());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MetricsExampleApplication.class, args);
	}

}