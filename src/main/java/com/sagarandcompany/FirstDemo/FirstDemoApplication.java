package com.sagarandcompany.FirstDemo;

import com.sagarandcompany.FirstDemo.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:spring-beans.xml")
public class FirstDemoApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(FirstDemoApplication.class, args);
        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        System.out.println(employeeService.employee());
    }
}
