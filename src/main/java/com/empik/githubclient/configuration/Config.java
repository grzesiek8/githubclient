package com.empik.githubclient.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class Config {

    @Bean
    public RestTemplate githubRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        UriTemplateHandler uriTemplateHandler = new RootUriTemplateHandler("https://api.github.com");

        return restTemplateBuilder.uriTemplateHandler(uriTemplateHandler).build();
    }
}