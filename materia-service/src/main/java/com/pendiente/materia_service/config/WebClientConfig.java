package com.pendiente.materia_service.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@Configurable
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClient() {
        return WebClient.builder();
    }
}
