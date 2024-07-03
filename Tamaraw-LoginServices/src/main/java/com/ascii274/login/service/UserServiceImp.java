package com.ascii274.login.service;


import com.ascii274.login.entity.User;
import com.ascii274.login.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserByMailMobile(String mailMobile) {
        return userRepository.getUserByMailMobile(mailMobile);
    }



    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }

}
