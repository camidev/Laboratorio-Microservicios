package com.udea.microserviceclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientController() {
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/clients")
    public String greetingAll() {
        return "greetingAll";
    }

    @RequestMapping("/clients/{id}")
    @HystrixCommand(fallbackMethod = "greetingDefault")
    public String greeting(Model model, @PathVariable("id") long id) {
        clientService = MicroserviceClientApplication.clientService();
        Client greeting = clientService.greeting(id);
        Map<String, Object> params = new HashMap<>();
        params.put("name", greeting.getName());
        params.put("email", greeting.getEmail());
        params.put("telephone", greeting.getTelephone());
        model.addAllAttributes(params);
        System.out.println(params);
        return "greeting";
    }

    public String greetingDefault(Model model, @PathVariable("id") long id) {
        Client greeting = clientService.greetingDefault();
        Map<String, Object> params = new HashMap<>();
        params.put("name", greeting.getName());
        params.put("email", greeting.getEmail());
        params.put("telephone", greeting.getTelephone());
        model.addAllAttributes(params);
        System.out.println(params);
        return "greeting";
    }

    @RequestMapping(method = GET)
    public List<Object> list() {
        return null;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Object get(@PathVariable String id) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = POST)
    public ResponseEntity<?> post(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return null;
    }

}
