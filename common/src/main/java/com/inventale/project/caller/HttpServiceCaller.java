package com.inventale.project.caller;

import com.inventale.project.model.Result;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ExecutorService;

// call specified service several times in paralle
public class HttpServiceCaller {
    private final ExecutorService executorService;
    private final WebClient webClient;
    private final String servicePath;
    private final int callsNumber;

    public HttpServiceCaller(
            ExecutorService executorService,
            WebClient webClient,
            String servicePath,
            int callsNumber) {
        this.executorService = executorService;
        this.webClient = webClient;
        this.servicePath = servicePath;
        this.callsNumber = callsNumber;
    }

    public void call() {
        for (int i = 0; i < callsNumber; i++) {
            executorService.submit(() ->
                    webClient
                            .get()
                            .uri(servicePath)
                            .retrieve()
                            .bodyToMono(Result.class)
                    .block()
            );
        }
    }
}