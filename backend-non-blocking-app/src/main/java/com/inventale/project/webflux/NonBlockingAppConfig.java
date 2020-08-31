package com.inventale.project.webflux;

import com.inventale.project.caller.HttpServiceCaller;
import com.inventale.project.webflux.services.NonBlockingHttpClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class NonBlockingAppConfig {
    @Bean
    public NonBlockingHttpClientService webfluxHttpClientService(
            @Value(value = "${backend.service-url}") String serviceUrl,
            @Value(value = "${backend.retry-number}") int retryNumber,
            @Value(value = "${backend.request-timeout-seconds}") int requestTimeoutSeconds
    ) {
        return new NonBlockingHttpClientService(
                WebClient.builder()
                        .baseUrl(serviceUrl)
                        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
                        .build(),
                retryNumber,
                requestTimeoutSeconds,
                serviceUrl
        );
    }

    // It calls /answer-non-blocking on startup
    @Bean
    public HttpServiceCaller httpServiceCaller(
            ExecutorService executorService,
            @Value(value = "${backend.non-blocking-service-url}") String nonBlockingServiceUrl,
            @Value(value = "${backend.number-of-calls-on-startup}") int numberOfCallsOnStartup
    ) {
        return new HttpServiceCaller(
                executorService,
                WebClient.builder()
                        .baseUrl(nonBlockingServiceUrl)
                        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
                        .build(),
                nonBlockingServiceUrl,
                numberOfCallsOnStartup
        );
    }

    // Pool of threads to call non-blocking service simultaneously on startup
    @Bean
    public ExecutorService callerExecutorService(
            @Value(value = "${backend.number-of-calls-on-startup}") int numberOfCallsOnStartup
    ) {
        return Executors.newFixedThreadPool(numberOfCallsOnStartup);
    }
}
