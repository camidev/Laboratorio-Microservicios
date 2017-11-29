package com.udea.microserviceclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    @Autowired
    protected RestTemplate restTemplate;
    protected String serviceUrl;

    public ClientService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public Client greeting(long id) {
        restTemplate = MicroserviceClientApplication.restTemplate();
        return restTemplate.getForObject(serviceUrl + "client/{id}", Client.class, id);
    }
    
    public Client greetingDefault() {
        return new Client(0, "Ha ocurrido un error", "Ha ocurrido un error", "Ha ocurrido un error");
    }

}
