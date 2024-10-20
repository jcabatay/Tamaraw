package com.ascii274.login.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.ascii274.login.entitydto.dto.UserCreationDto;
import com.ascii274.login.entitydto.entity.User;
import com.ascii274.login.repository.UserRepository;
import com.ascii274.login.service.UserServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/***************
 * IMPORTANT:
 * To run this Test, should docker-compose running
 **************/
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class UserControllerTest {
    private final static LocalDateTime LOCAL_DATE = LocalDateTime.of(2024,07,03,22,52,00);

    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserServiceImp userServiceImp;


    // Functional
//    @Before
//    public void resetDB() {
//        userRepository.deleteAll();
//    }

    // Functional
    @Test
    public void contextLoads() throws Exception{
        assertThat(userController).isNotNull();
    }


    @Test
    public void shouldReturnDefaultMessage() throws Exception{
        this.mvc.perform( get ("/user/test-message"))
                .andDo(print())
                .andExpect(status().isOk())  // code 200 ok
                .andExpect(content().string(containsString("Hello, Tamaraw Login Services")));
    }

    @Test
    public void givenIndexPage_whenMockMvc_thenReturnsIndexViewName() throws Exception {
        this.mvc.perform(get("/user/index")).andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("index"));
    }

    @Test
    public void addUser_shouldGetSavedUser(){
        UserCreationDto userCreationDto = new UserCreationDto(
                "Shiva","Bullterrier","shiava@mail.com","mypassword");
        User savedUser = userServiceImp.save(userCreationDto);
        assertThat(savedUser.getName().equals( userCreationDto.getName()));
    }

}
