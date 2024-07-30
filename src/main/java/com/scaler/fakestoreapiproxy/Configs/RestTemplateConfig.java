package com.scaler.fakestoreapiproxy.Configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.beans.BeanProperty;
@Configuration

public class RestTemplateConfig {
    @Bean
    @LoadBalanced// since we are calling using this rest template we are making this as  load baalnced.
    public RestTemplate getRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}
