package com.inventale.project.webflux.controller;

import com.inventale.project.model.HelloWorldResult;
import com.inventale.project.webflux.services.NonBlockingHttpClientService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@Timed
public class NonBlockingController {
    private final NonBlockingHttpClientService nonBlockingHttpClientService;

    @Autowired
    public NonBlockingController(
            NonBlockingHttpClientService nonBlockingHttpClientService
    ) {
        this.nonBlockingHttpClientService = nonBlockingHttpClientService;
    }

    @RequestMapping(value = "/hello-non-blocking", method = { RequestMethod.GET })
    public Mono<HelloWorldResult> helloNonBlocking() {
        log.info("NonBlockingController, the thread is {}", Thread.currentThread().getName());
        return nonBlockingHttpClientService.getHelloWorld();
    }
}
