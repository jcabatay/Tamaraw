package com.ascii274.login.service;

import com.ascii274.login.entity.User;
import com.ascii274.login.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

// Mocking with @MockBean
@RunWith(SpringRunner.class)
public class UserServiceImpTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @TestConfiguration
    static class UserServiceImpTestConfiguration{
        @Bean
        public UserService userService(){
            return new UserServiceImp();
        }
    }

    @Before
    public void setUp(){
        User newUser = new User(1000L,"test-user-id",
                "user-id-password","user-name",
                "user-firstname","user-last-name","user@mail.com");
        Mockito.when(userRepository.findById(newUser.getId()))
                .thenReturn(Optional.of(newUser));
    }

     @Test
    public void whenValidId_thenUserShouldBeFound(){
        Long id = 1000L;
        Optional<User> found = userService.getUserById(id);
        assertThat(found.get().getId())
                .isEqualTo(id);

    }


}
