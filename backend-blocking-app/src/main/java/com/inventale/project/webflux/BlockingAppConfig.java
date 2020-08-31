package com.inventale.project.webflux;

import com.inventale.project.caller.HttpServiceCaller;
import com.inventale.project.webflux.services.BlockingHttpClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Configuration
public class BlockingAppConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
    {
        return restTemplateBuilder
           .build();
    }

    @Bean
    public BlockingHttpClientService helloWorldHttpService(
            RestTemplate restTemplate,
            @Value(value = "${backend.service-url}") String serviceUrl
    ) {
        return new BlockingHttpClientService(
                restTemplate,
                serviceUrl
        );
    }

    @Bean
    public HttpServiceCaller httpServiceCaller(
            ExecutorService executorService,
            @Value(value = "${backend.blocking-service-url}") String blockingServiceUrl,
            @Value(value = "${backend.number-of-calls-on-startup}") int numberOfCallsOnStartup
    ) {
        return new HttpServiceCaller(
                executorService,
                WebClient.builder()
                        .baseUrl(blockingServiceUrl)
                        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
                        .build(),
                blockingServiceUrl,
                numberOfCallsOnStartup
        );
    }

    @Bean
    public ExecutorService callerExecutorService(
            @Value(value = "${backend.number-of-calls-on-startup}") int numberOfCallsOnStartup
    ) {
        return Executors.newFixedThreadPool(numberOfCallsOnStartup);
    }
}
