package com.ascii274.login.repository;


import com.ascii274.login.entity.User;
import io.micrometer.common.lang.NonNullApi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
@NonNullApi
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findByUserId(String userId);

}
