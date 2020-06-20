package com.sagarandcompany.FirstDemo.controller;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.service.EmployeeService;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public ModelAndView save(@RequestBody Employee employee) {
        Employee dbEmp = employeeService.save(employee);
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

    @GetMapping(value = "/search", produces = "application/json")
    @ResponseBody
    public ResponseDTO searchRecordWithNameandEmail(@RequestParam("name") String name, @RequestParam("email") String email) {
        return employeeService.searchRecordWithNameandEmail(name, email);
    }

    @GetMapping(value = "/search2", produces = "application/json")
    @ResponseBody
    public ResponseDTO search2(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email) {
        return employeeService.searchRecordWithNameOrEmail(name, email);
    }

    @GetMapping(value = "/search3", produces = "application/json")
    @ResponseBody
    public List<Employee> findBySalaryGreaterThan(@RequestParam(value = "salary") Integer salary) {
        return employeeService.findBySalaryGreaterThan(salary);
    }

    @GetMapping(value = "/search4", produces = "application/json")
    @ResponseBody
    public List<Employee> findBySalaryGreaterThanAndSalaryLessThan(@RequestParam(value = "min") Integer min, @RequestParam(value = "max") Integer max) {
        return employeeService.findBySalaryGreaterThanAndSalaryLessThan(min, max);
    }

    @GetMapping(value = "/search5", produces = "application/json")
    @ResponseBody
    public List<Employee> findAllByNameStartingWith(@RequestParam(value = "name") String name) {
        return employeeService.search4(name);
    }

    @GetMapping(value = "/search6", produces = "application/json")
    @ResponseBody
    public List<Employee> search6(@RequestParam(value = "name") String name) {
        return employeeService.search6(name);
    }

    @GetMapping(value = "/criteriaDemo1", produces = "application/json")
    @ResponseBody
    public List<Employee> criteriaDemo1(@RequestParam(value = "name") String name) {
        return employeeService.criteriaDemo1(name);
    }

    @GetMapping(value = "/criteriaDemo2", produces = "application/json")
    @ResponseBody
    public List<Employee> criteriaDemo2(@RequestParam(value = "name") String name,
                                        @RequestParam("salary") Integer salary) {
        return employeeService.criteriaDemo2(name, salary);
    }

    @GetMapping(value = "/criteriaDemo3", produces = "application/json")
    @ResponseBody
    public List<Employee> criteriaDemo3(@RequestParam(value = "name") String name) {
        return employeeService.criteriaDemo3(name);
    }

    @GetMapping(value = "/criteriaDemo4", produces = "application/json")
    @ResponseBody
    public List<Employee> criteriaDemo4(@RequestParam(value = "name") String name) {
        return employeeService.criteriaDemo4(name);
    }

    @GetMapping(value = "/criteriaDemo5", produces = "application/json")
    @ResponseBody
    public List<Employee> criteriaDemo5(@RequestParam(value = "name") String name) {
        return employeeService.criteriaDemo5(name);
    }

    @GetMapping(value = "/criteriaDemo6", produces = "application/json")
    @ResponseBody
    public List<Employee> criteriaDemo6(@RequestParam(value = "name") String name) {
        return employeeService.criteriaDemo6(name);
    }

    @GetMapping(value = "/criteriaDemo7", produces = "application/json")
    @ResponseBody
    public List<Employee> criteriaDemo7(@RequestParam(value = "name") String name) {
        return employeeService.criteriaDemo7(name);
    }

    @GetMapping(value = "/criteriaDemo8", produces = "application/json")
    @ResponseBody
    public List<Employee> criteriaDemo8(@RequestParam(value = "name") String name) {
        return employeeService.criteriaDemo8(name);
    }
}
