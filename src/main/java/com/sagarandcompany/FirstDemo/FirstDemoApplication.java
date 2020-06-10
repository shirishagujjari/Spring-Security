package com.sagarandcompany.FirstDemo;

import com.sagarandcompany.FirstDemo.service.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:spring-beans.xml")
public class FirstDemoApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(FirstDemoApplication.class, args);
//        AccountService accountService1 = (AccountService) applicationContext.getBean("accountService1");
//        accountService1.getEmployeeService();
//
//
//        AccountService accountService2 = (AccountService) applicationContext.getBean("accountService2");
//        accountService2.getEmployeeService();


//        AccountService accountService3 = applicationContext.getBean(AccountService.class);
//        accountService1.getEmployeeService();
//        AccountService accountService4 = applicationContext.getBean(AccountService.class);
//        accountService1.getEmployeeService();
    }
}
