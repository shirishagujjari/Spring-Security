package com.sagarandcompany.FirstDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class AccountService {
    EmployeeService employeeService;
    @Autowired
    ApplicationContext applicationContext;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public EmployeeService getEmployeeService() {
        return applicationContext.getBean(EmployeeService.class);

    }

}
