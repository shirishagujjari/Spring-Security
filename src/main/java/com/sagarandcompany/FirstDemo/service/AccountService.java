package com.sagarandcompany.FirstDemo.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

public class AccountService implements InitializingBean, DisposableBean {
    EmployeeService employeeService;
    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    public void initlizaation() {
        System.out.println("Post contruct method is calling..................");
    }

    public void init() {
        System.out.println("Calling init method...........");
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("calling afterPropertiesSet method after setting all values.........." + this.toString());
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("calling this destroy method ....");
    }

    public EmployeeService getEmployeeService() {
        return applicationContext.getBean(EmployeeService.class);

    }

}
