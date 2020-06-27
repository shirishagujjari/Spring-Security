package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Role;
import com.sagarandcompany.FirstDemo.domain.User;
import com.sagarandcompany.FirstDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    public void init() {
        Role role = Role.builder().name("ADMIN").build();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        User user = User.builder()
                .username("sagar")
                .active(1)
                .password(bCryptPasswordEncoder.encode("java"))
                .firstName("sagar shankhala")
                .roles(roles)
                .build();
        userRepository.save(user);
    }
}
