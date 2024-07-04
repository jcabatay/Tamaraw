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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Mocking with @MockBean
@RunWith(SpringRunner.class)
public class UserServiceImpTest {
    private final static LocalDateTime LOCAL_DATE = LocalDateTime.of(2024,07,03,22,52,00);

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

        User newUser = new User(1000L,
                "Joel","my lastname",
                "+34123456789","mypasswoard",LOCAL_DATE);
        Mockito.when(userRepository.findById(newUser.getId()))
                .thenReturn(Optional.of(newUser));
    }

     @Test
    public void whenGetUserMailMobile_thenUserShouldBeFound(){
        Long id = 1000L;
        String mailMobile = "+34123456789";
        Optional<User> found = userService.getUserByMailMobile(mailMobile);
        assertThat(found.get().getMailMobile())
                .isEqualTo(mailMobile);

    }


    @Test
    public void whenGetAllUsers_returnOkWithListOfUsers() throws Exception {

        List<User> userList = new ArrayList<>();
        User user1 = new User(1L,"joel","joellastname",
                "joel@mail.com","joelpassword",LOCAL_DATE);
        User user2 = new User(2L,"joel","shiva lastname",
                "shiva@mail.com", "shivapassword",LOCAL_DATE);
        userList.add(user1);
        userList.add(user2);
        Mockito.when(userService.getAllUsers()).thenReturn(userList);
        assertEquals("joel",userList.get(0).getName());
        assertEquals(2L, userList.get(1).getId());

    }

}
