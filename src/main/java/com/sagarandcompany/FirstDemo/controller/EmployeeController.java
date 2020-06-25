package com.sagarandcompany.FirstDemo.controller;

import com.sagarandcompany.FirstDemo.domain.Department;
import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.service.EmployeeService;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Employee employee) {
//        Department department = new Department();
//        department.setName("Computer");
//        employee.setDepartment(department);
        Employee dbEmp = employeeService.
                save(employee);
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }

    @GetMapping(value = "/get/{id}", produces = "application/json")
    @ResponseBody
    public Employee get(@PathVariable("id") Long id) {
        return employeeService.get(id);
    }

    @GetMapping(value = "/findByEmail/{email}", produces = "application/json")
    @ResponseBody
    public ResponseDTO findByEmail(@PathVariable("email") String email) {
        return employeeService.findByEmail(email);
    }
}
