package com.sagarandcompany.FirstDemo.controller;

import com.sagarandcompany.FirstDemo.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @PostMapping("/save")
    public ModelAndView save(@RequestBody Employee employee) {
        System.out.println(employee.toString());
        ModelAndView modelAndView = new ModelAndView("success");
        return modelAndView;
    }
}
