package com.example.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class CustomController {
    private  final Logger logger = Logger.getLogger("HelloController");
    @Autowired
    public RestTemplate restTemplate;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index() {
        return restTemplate.getForEntity("http://localhost:hello-service:8081",String.class).getBody();
    }

}
