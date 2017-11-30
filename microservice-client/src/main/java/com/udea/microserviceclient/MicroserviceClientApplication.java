package com.udea.microserviceclient;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
@EnableHystrix
@EnableCircuitBreaker
@RestController
@ComponentScan(basePackages = {"com.udea.microserviceclient"})
public class MicroserviceClientApplication {

    private static final String SERVICE_URL = "http://localhost:5555";

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceClientApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public static RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public static ClientService clientService() {
        return new ClientService(SERVICE_URL);
    }

    @Bean
    public ClientController clientController() {
        return new ClientController();
    }
}
