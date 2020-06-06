package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public Employee get(String id, String name) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setEmail("test@gmail.com");
        employee.setName(name);
        return employee;
    }
    public Employee get2(Employee employee) {
        return employee;
    }
}
