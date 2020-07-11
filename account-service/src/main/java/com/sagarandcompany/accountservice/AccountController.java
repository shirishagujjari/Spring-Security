package com.sagarandcompany.accountservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {
    @Value("${account.name}")
    private String name;


    @GetMapping("/account/get/{id}")
    public Map<String, String> get(@PathVariable String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("email", "test@gmail.com");
        return map;
    }
}
