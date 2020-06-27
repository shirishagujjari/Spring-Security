package com.sagarandcompany.FirstDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/admin/home")
    public ModelAndView getSecurePage(){
        return new ModelAndView("admin");
    }
    @GetMapping("/home")
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "Shrisha");
        return modelAndView;
    }

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "Testing------------");
        return modelAndView;
    }
}
