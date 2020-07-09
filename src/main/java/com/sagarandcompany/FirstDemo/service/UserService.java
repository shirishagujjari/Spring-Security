package com.sagarandcompany.FirstDemo.service;

import com.sagarandcompany.FirstDemo.domain.Account;
import com.sagarandcompany.FirstDemo.domain.User;
import com.sagarandcompany.FirstDemo.repository.UserRepository;
import com.sagarandcompany.FirstDemo.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

    public ResponseDTO save(User user) {
        User dbUser = userRepository.save(user);
        Account account = Account.builder().id(2L).balance(5000L).build();
        restTemplate.postForEntity("http://localhost:8090/account/save", account, Account.class);
        return ResponseDTO.builder().status(true).message("Record is saved Successfully with Id=" + dbUser.getId()).build();
    }

    public ResponseDTO get(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            Account account = restTemplate.getForEntity("http://localhost:8090/account/get/" + id, Account.class).getBody();
            optionalUser.get().setAccount(account);
            return ResponseDTO.builder().status(true).data(optionalUser.get()).build();
        }
        return ResponseDTO.builder().status(false).message("Record is not found with Id=" + id).build();
    }

    public ResponseDTO delete(Long id) {
        userRepository.deleteById(id);
        return ResponseDTO.builder().status(true).message("Record is deleted successfully").build();
    }

    public ResponseDTO getAll() {
        List<User> userList = userRepository.findAll();
        return ResponseDTO.builder().status(true).data(userList).build();
    }
}
