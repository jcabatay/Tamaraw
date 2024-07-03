package com.ascii274.login.service;

import com.ascii274.login.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Optional<User> getUserByMailMobile(String mailMobile);

    public List<User> getAllUsers();

    public Optional<User> save(User user);
}
