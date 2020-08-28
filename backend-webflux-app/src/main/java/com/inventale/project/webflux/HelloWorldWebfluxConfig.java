package com.inventale.project.webflux;

import com.inventale.project.webflux.services.HelloWorldWebfluxHttpService;
import com.inventale.project.webflux.services.HelloWorldWebfluxService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HelloWorldWebfluxConfig {
    @Bean
    public HelloWorldWebfluxService helloWorldService() {
        return new HelloWorldWebfluxService();
    }

    @Bean
    public HelloWorldWebfluxHttpService helloWorldHttpService(
            @Value(value = "${backend.service-url}") String serviceUrl,
            @Value(value = "${backend.retry-number}") int retryNumber,
            @Value(value = "${backend.request-timeout-seconds}") int requestTimeoutSeconds
    ) {
        return new HelloWorldWebfluxHttpService(
                WebClient.builder()
                        .baseUrl(serviceUrl)
                        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
                        .build(),
                retryNumber,
                requestTimeoutSeconds,
                serviceUrl
        );
    }
}
