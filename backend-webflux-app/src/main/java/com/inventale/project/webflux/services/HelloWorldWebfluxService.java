package com.inventale.project.webflux.services;

import com.inventale.project.webflux.model.HelloWorldResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class HelloWorldWebfluxService {
    public Mono<HelloWorldResult> getHelloWorld() {
        // way to handle a blocking call
        return Mono.fromSupplier(this::getHelloWorldBlocking)
                .subscribeOn(Schedulers.elastic());
    }

    @SneakyThrows
    private HelloWorldResult getHelloWorldBlocking() {
        //blocking waiting
        Thread.sleep(1000);
        log.info("getHelloWorldBlocking, the thread is {}", Thread.currentThread().getName());
        return new HelloWorldResult("Hello world, webflux!");
    }
}