package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Employee;
import com.sagarandcompany.FirstDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee get(Long id) {
        return employeeRepository.findById(id).get();
    }
}
