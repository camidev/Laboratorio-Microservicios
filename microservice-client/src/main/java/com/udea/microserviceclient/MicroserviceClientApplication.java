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

    @Bean
    public CommandLineRunner demo(ClientRepository repository) {
        return (String[] args) -> {
            // save a couple of customers
            repository.save(new Client(1017238295, "Juan Camilo", "camov1209@gmail.com", "3154415064"));
            repository.save(new Client(1017266454, " Luisa Fernanda", "luisa0129@gmail.com", "3102791015"));
            repository.save(new Client(5887184, "Pedro", "pedro1024@gmail.com", "3112270256"));
            repository.save(new Client(1014897213, "Maria Fernanda", "mafe@gmail.com", "3142510768"));

            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");

            // fetch an individual customer by ID
//            Customer customer = repository.findOne(1L);
//            log.info("Customer found with findOne(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");

            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            for (Customer bauer : repository.findByLastName("Bauer")) {
//                log.info(bauer.toString());
//            }
//            log.info("");
        };
    }

}
