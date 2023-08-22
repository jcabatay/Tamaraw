package com.ascii274.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger((UserController.class));

    @GetMapping( value = "/test" )
    public String test(){
        return "Hello Bahay-LoginServices";
    }

}
