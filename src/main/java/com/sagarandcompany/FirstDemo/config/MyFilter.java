package com.sagarandcompany.FirstDemo.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        System.out.println("............." + request.getRemoteHost());
//        System.out.println("............." + request.getLocale().getCountry());
        chain.doFilter(request, response);
    }
}
