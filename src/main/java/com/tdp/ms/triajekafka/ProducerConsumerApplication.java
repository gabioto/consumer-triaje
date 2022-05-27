package com.tdp.ms.triajekafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

import com.tdp.genesis.core.starter.web.runner.StarterWebApplication;


@EnableWebFlux
@SpringBootApplication
public class ProducerConsumerApplication extends StarterWebApplication{

    public static void main(String[] args) {
        SpringApplication.run(ProducerConsumerApplication.class, args);
    }

}