package com.ascii274.login.service;


import com.ascii274.login.entitydto.dto.UserCreationDto;
import com.ascii274.login.entitydto.dto.UserResponseDto;
import com.ascii274.login.entitydto.entity.User;
import com.ascii274.login.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
@Transactional

//public class UserServiceImp implements UserServiceBorra{
public class UserServiceImp{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImp(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;

    }

    //    @Override
    public List<UserResponseDto> getUserByMailMobile(String mailMobile) {
        return userRepository.getUserByMailMobile(mailMobile);
    }

//    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
    public User save(UserCreationDto userCreationDto) {
        User user = convertToEntity(userCreationDto);
        userRepository.save(user);
        return user;

    }

    //DTO's convert

    public UserCreationDto convertToDto(User user){
        return modelMapper.map(user, UserCreationDto.class);
    }

    public User convertToEntity(UserCreationDto userCreationDto){
        return modelMapper.map(userCreationDto, User.class);

    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }



}
