package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;

public class EmployeeService {
    public Employee get() {
        Employee employee = new Employee();
        employee.setEmail("test@gmail.com");
        employee.setName("test");
        return employee;
    }
}
