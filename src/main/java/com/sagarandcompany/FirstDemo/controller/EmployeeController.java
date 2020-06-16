package com.sagarandcompany.FirstDemo.controller;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.domain.PrivateEmployee;
import com.sagarandcompany.FirstDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute PrivateEmployee employee) {
        employee.setTime(30);
        Employee dbEmp = employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    public Employee get(@PathVariable("id") Long id) {
        return employeeService.get(id);
    }
}
