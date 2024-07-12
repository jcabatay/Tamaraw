package com.ascii274.login.service;

import com.ascii274.login.entitydto.dto.UserCreationDto;
import com.ascii274.login.entitydto.dto.UserResponseDto;
import com.ascii274.login.entitydto.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserResponseDto> getUserByMailMobile(String mailMobile);

    public List<User> getAllUsers();

    public User save(UserCreationDto userCreationDto);

//    public Optional<UserCreationDto> saveUserCreationDto(User user);
}
