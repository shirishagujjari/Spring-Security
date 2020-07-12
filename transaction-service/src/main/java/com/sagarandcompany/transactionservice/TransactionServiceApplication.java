package com.sagarandcompany.transactionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class TransactionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionServiceApplication.class, args);
    }

    @GetMapping(value = "/get", produces = "application/json")
    public Map<String, String> get() {
        Map<String, String> map = new HashMap<>();
        map.put("balance", "1000");
        map.put("test", "tranaction");
        return map;
    }
}
