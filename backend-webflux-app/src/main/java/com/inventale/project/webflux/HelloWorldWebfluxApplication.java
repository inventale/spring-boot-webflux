package com.inventale.project.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.inventale.project.webflux")
public class HelloWorldWebfluxApplication {
    public static void main(String... args) {
        SpringApplication.run(HelloWorldWebfluxApplication.class, args);
    }
}
