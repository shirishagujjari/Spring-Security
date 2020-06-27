package com.sagarandcompany.FirstDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        BasicAuthenticationEntryPoint basicAuthenticationEntryPoint = new BasicAuthenticationEntryPoint();
//        basicAuthenticationEntryPoint.setRealmName("test");
//
//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(basicAuthenticationEntryPoint);
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        BasicAuthenticationEntryPoint basicAuthenticationEntryPoint=new BasicAuthenticationEntryPoint();
//        basicAuthenticationEntryPoint.setRealmName("anydumydata");
//        http.authorizeRequests()
//                .antMatchers("/test").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(basicAuthenticationEntryPoint);
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        BasicAuthenticationEntryPoint basicAuthenticationEntryPoint=new BasicAuthenticationEntryPoint();
//        basicAuthenticationEntryPoint.setRealmName("anydumydata");
//        http.authorizeRequests()
//                .antMatchers("/test").hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(basicAuthenticationEntryPoint);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
                .authenticated().and().csrf().disable()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/admin/home")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder passwordEncoder = passwordEncoder();
//        auth.
//                inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder)
//                .withUser("sagar")
//                .password(passwordEncoder.encode("test"))
//                .roles("ADMIN","USER");
//    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = passwordEncoder();
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery("select username, password,active from user where username=? ")
                .authoritiesByUsernameQuery("select u.username, r.name from user u inner join user_role ur on(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.username=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
