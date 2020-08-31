package com.inventale.project.webflux.services;

import com.inventale.project.model.HelloWorldResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExternalService {
    @SneakyThrows
    public HelloWorldResult getHelloWorldBlocking() {
        //blocking waiting
        Thread.sleep(1000);
        return new HelloWorldResult("Hello world!");
    }
}