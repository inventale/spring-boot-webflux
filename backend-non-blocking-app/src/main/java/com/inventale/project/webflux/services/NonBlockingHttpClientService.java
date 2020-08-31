package com.inventale.project.webflux.services;

import com.inventale.project.model.HelloWorldResult;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

public class NonBlockingHttpClientService {
    private final WebClient webClient;
    private final int retryCount;
    private final int requestTimeoutSeconds;
    private final String servicePath;

    public NonBlockingHttpClientService(
            WebClient webClient,
            int retryCount,
            int requestTimeoutSeconds,
            String servicePath
    ) {
        this.webClient = webClient;
        this.retryCount = retryCount;
        this.requestTimeoutSeconds = requestTimeoutSeconds;
        this.servicePath = servicePath;
    }

    public Mono<HelloWorldResult> getHelloWorld() {
        return webClient
                .get()
                .uri(servicePath)
                .retrieve()
                .bodyToMono(HelloWorldResult.class)
                .retryWhen(Retry.fixedDelay(retryCount, Duration.ofSeconds(requestTimeoutSeconds)));
    }
}