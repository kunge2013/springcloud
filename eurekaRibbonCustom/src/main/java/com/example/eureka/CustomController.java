package com.example.eureka;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
public class CustomController {
    private  final Logger logger = Logger.getLogger("HelloController");
    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object index() {
        List<String> services = client.getServices();
        logger.info("services == " + services);
        Map<String, List<ServiceInstance>> serviceMap = Maps.newHashMap();
        for(String serviceId : services) {
            serviceMap.put(serviceId, client.getInstances(serviceId));
        }
        //logger.info("message =======>"+ restTemplate.getForEntity("http://HELLO-SERVICE/test/hello",String.class).getBody());
        return restTemplate.getForEntity("http://HELLO-SERVICE/test/hello",String.class).getBody();
    }

}
