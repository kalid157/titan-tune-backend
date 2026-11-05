package com.titan.tune.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.titan.tune")
@EntityScan(basePackages = "com.titan.tune.domain.model")
@EnableJpaRepositories(basePackages = "com.titan.tune.domain.repository")
public class TitanTuneApplication {
    public static void main(String[] args) {
        SpringApplication.run(TitanTuneApplication.class, args);
    }
}