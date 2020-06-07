package com.sagarandcompany.FirstDemo.controller;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/get", produces = "application/json")
    public Employee get2(Employee employee) {
        return employeeService.get2(employee);
    }

    @PostMapping(value = "/save")
    public Employee save(@ModelAttribute Employee employee) {
        return employee;
    }

    @GetMapping(value = "/get/matrix", produces = "application/xml")
    public Employee getMatrix(@MatrixVariable("id") String id, @MatrixVariable("name") String name) {
        return employeeService.get(id, name);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Employee delete(@PathVariable String id) {
        return employeeService.get(id, "");
    }

}
