package com.inventale.project.webflux.services;

import com.inventale.project.model.HelloWorldResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class BlockingHttpClientService {
    private final RestTemplate restTemplate;
    private final String servicePath;

    public BlockingHttpClientService(
            RestTemplate restTemplate,
            String servicePath
    ) {
        this.restTemplate = restTemplate;
        this.servicePath = servicePath;
    }

    public HelloWorldResult getHelloWorld() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                servicePath,
                HttpMethod.GET,
                entity,
                HelloWorldResult.class
        ).getBody();
    }
}