package com.example.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/test")
public class HelloController {
    private  final Logger logger = Logger.getLogger("HelloController");
    @Autowired
    public DiscoveryClient client;
    @RequestMapping("/hello")
    public String index() {
         // 获取所有的应用信息
//        client.getInstances("hello");
//        List<String> ids = client.getServices();
//        ids.forEach(id -> logger.info(client.getInstances(id) + ""));
        return "hello world !";
    }

}
