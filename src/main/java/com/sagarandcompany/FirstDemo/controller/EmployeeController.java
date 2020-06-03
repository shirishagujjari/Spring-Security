package com.sagarandcompany.FirstDemo.controller;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/get")
    public Employee get() {
        return employeeService.get();
    }

}
