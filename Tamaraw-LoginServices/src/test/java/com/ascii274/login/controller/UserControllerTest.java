package com.ascii274.login.controller;

import com.ascii274.BahayLoginServicesApp;
import com.ascii274.login.controller.UserController;
import com.ascii274.login.entity.User;
import com.ascii274.login.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUsers_whenGetUsers_thenStatus200() throws Exception{
        createUser("Joel");
        createUser("Shiva");
        mvc.perform(get("/v1/getall").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
                .andExpect(jsonPath("$[0].userName",is("Joel")))
                .andExpect(jsonPath("$[1].userName",is("Shiva")));

    }

    // Functional
    private void createUser(String userName) {
        User user = new User(userName);
        userRepository.saveAndFlush(user);
    }

    // Functional
    @Before
    public void resetDB() {
        userRepository .deleteAll();
    }

    // Functional
    @Test
    public void contextLoads() throws Exception{

    }
}
