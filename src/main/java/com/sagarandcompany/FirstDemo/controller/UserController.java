package com.sagarandcompany.FirstDemo.controller;

import com.sagarandcompany.FirstDemo.domain.User;
import com.sagarandcompany.FirstDemo.service.UserService;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseDTO save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    public ResponseDTO get(@PathVariable("id") Long id) {
        return userService.get(id);
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public ResponseDTO getALL() {
        return userService.getAll();
    }

    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseDTO delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
