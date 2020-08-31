package com.inventale.project.webflux;

import com.inventale.project.caller.HttpServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.inventale.project.webflux")
public class BlockingApplication implements ApplicationRunner {
    @Autowired
    private HttpServiceCaller blockingServiceCaller;

    public static void main(String... args) {
        SpringApplication.run(BlockingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        blockingServiceCaller.call();
    }
}
