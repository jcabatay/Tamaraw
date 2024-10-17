package com.ascii274.login.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class AdminControllerTest {
    private final static LocalDateTime LOCAL_DATE = LocalDateTime.of(2024,07,03,
            22,52,00);
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yy hh/mm/ss");



    @Autowired
    private MockMvc mvc;

    @Autowired
    private AdminController adminController;

//    @Test
//    public void getAllUsers() throws Exception{
//        mvc.perform(MockMvcRequestBuilders
//                .get("/admin/getall")
//                .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.allusers").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.allusers[*]").isNotEmpty());
//    }

    @Test
    public void contextLoads() throws Exception{
        assertThat(adminController).isNotNull();
    }


}
