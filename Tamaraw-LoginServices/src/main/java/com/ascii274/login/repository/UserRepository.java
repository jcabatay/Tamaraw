package com.ascii274.login.repository;


import com.ascii274.login.entitydto.dto.UserCreationDto;
import com.ascii274.login.entitydto.dto.UserResponseDto;
import com.ascii274.login.entitydto.entity.User;
import io.micrometer.common.lang.NonNullApi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@NonNullApi
public interface UserRepository extends JpaRepository<User,Long> {

    public List<UserResponseDto> getUserByMailMobile(String mailMobile);
    public Optional<User> save(UserCreationDto userCreationDto);

}
