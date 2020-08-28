package com.inventale.project.webflux.controller;

import com.inventale.project.webflux.model.HelloWorldResult;
import com.inventale.project.webflux.services.HelloWorldWebfluxHttpService;
import com.inventale.project.webflux.services.HelloWorldWebfluxService;
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
public class HelloWorldWebfluxController {
    private final HelloWorldWebfluxService helloWorldWebfluxService;
    private final HelloWorldWebfluxHttpService helloWorldWebfluxHttpService;

    @Autowired
    public HelloWorldWebfluxController(
            HelloWorldWebfluxService helloWorldWebfluxService,
            HelloWorldWebfluxHttpService helloWorldWebfluxHttpService
    ) {
        this.helloWorldWebfluxService = helloWorldWebfluxService;
        this.helloWorldWebfluxHttpService = helloWorldWebfluxHttpService;
    }

    @RequestMapping(value = "/hello-webflux", method = { RequestMethod.GET })
    public Mono<HelloWorldResult> helloWorld() {
        return helloWorldWebfluxService.getHelloWorld();
    }

    @RequestMapping(value = "/hello-webflux-http", method = { RequestMethod.GET })
    public Mono<HelloWorldResult> helloWorldHttp() {
        return helloWorldWebfluxHttpService.getHelloWorld();
    }
}
