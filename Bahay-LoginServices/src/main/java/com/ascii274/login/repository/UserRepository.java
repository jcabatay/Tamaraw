package com.ascii274.login.repository;

import com.ascii274.login.entity.User;
import io.micrometer.common.lang.NonNullApi;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@NonNullApi
public interface UserRepository extends JpaRepository<User,Long> {

    public Optional<User> findById (Long UserId);

    public List<User> findAll();


}
