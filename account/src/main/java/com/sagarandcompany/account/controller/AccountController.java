package com.sagarandcompany.account.controller;

import com.sagarandcompany.account.domain.Account;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @GetMapping("/get/{id}")
    public Account get(@PathVariable("id") Long id) {
        return Account.builder().id(id).balance(2000L).build();
    }

    @PostMapping("/save")
    public Account get(@RequestBody Account account) {
        System.out.println(account.toString());
        return account;
    }
}
