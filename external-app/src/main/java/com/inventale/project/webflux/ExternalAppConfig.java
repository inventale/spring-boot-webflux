package com.inventale.project.webflux;

import com.inventale.project.webflux.services.ExternalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExternalAppConfig {
    @Bean
    public ExternalService externalService() {
        return new ExternalService();
    }
}
