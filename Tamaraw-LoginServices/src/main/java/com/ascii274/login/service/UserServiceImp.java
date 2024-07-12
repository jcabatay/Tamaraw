package com.ascii274.login.service;


import com.ascii274.login.entitydto.dto.UserCreationDto;
import com.ascii274.login.entitydto.entity.User;
import com.ascii274.login.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    private ModelMapper modelMapper;

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
    public User save(UserCreationDto userCreationDto) {
        User user = convertToEntity(userCreationDto);
        userRepository.save(user);
        return user;

    }

    //DTO's convert

    private UserCreationDto convertToDto(User user){
        return modelMapper.map(user, UserCreationDto.class);
    }

    private User convertToEntity(UserCreationDto userCreationDto){
        return modelMapper.map(userCreationDto, User.class);

    }



}
