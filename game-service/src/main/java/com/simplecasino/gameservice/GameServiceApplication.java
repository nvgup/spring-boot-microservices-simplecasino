package com.simplecasino.gameservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.jackson.JacksonDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
@EnableFeignClients("com.simplecasino.gameservice.service")
public class GameServiceApplication {

    @Bean
    public JacksonDecoder jacksonDecoder(ObjectMapper objectMapper) {
        return new JacksonDecoder(objectMapper);
    }

    public static void main(String[] args) {
        SpringApplication.run(GameServiceApplication.class, args);
    }
}