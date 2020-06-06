package com.sagarandcompany.FirstDemo.controller;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Resource
    EmployeeService employeeService;

    @GetMapping("/get/{id}/{name}")
    public Employee get(@PathVariable String id, @PathVariable String name) {
        return employeeService.get(id, name);
    }

    @GetMapping(value = "/get", produces = "application/xml")
    public Employee get2(Employee employee) {
        return employeeService.get2(employee);
    }

}
