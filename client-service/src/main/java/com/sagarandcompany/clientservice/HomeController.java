package com.sagarandcompany.clientservice;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    EurekaClient eurekaClient;

    @GetMapping("/home/{id}")
    public Map<String, String> get(@PathVariable String id) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("account-service".toUpperCase(), false);
        String baseUrl = instanceInfo.getHomePageUrl();
        return restTemplate.getForEntity(baseUrl + "/account/get/" + id, Map.class).getBody();
    }
}
