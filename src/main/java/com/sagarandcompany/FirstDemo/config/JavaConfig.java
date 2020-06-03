package com.sagarandcompany.FirstDemo.config;

import com.sagarandcompany.FirstDemo.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }
}
