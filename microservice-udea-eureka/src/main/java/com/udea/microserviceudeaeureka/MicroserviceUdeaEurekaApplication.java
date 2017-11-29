package com.udea.microserviceudeaeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceUdeaEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUdeaEurekaApplication.class, args);
	}
}
