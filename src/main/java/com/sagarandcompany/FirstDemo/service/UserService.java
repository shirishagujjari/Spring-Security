package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.User;
import com.sagarandcompany.FirstDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (userRepository.count() == 0) {
            User user = User.builder()
                    .username("sagarmal624@gmail.com")
                    .password(this.passwordEncoder.encode("India@2020"))
                    .name("Sagar")
                    .roles(new HashSet<String>(Arrays.asList("ROLE_SUPER_ADMIN")))
                    .build();
            userRepository.save(user);
        }
    }
}
