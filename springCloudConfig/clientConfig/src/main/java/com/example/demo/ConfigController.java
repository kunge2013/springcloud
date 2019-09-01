package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${info.test}")
    private String name;
    @RequestMapping(value = "/hi")
    public String hi(){
        return name;
    }
}
