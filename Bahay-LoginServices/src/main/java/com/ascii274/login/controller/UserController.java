package com.ascii274.login.controller;

import com.ascii274.login.entity.User;
import com.ascii274.login.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger((UserController.class));

    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping(value="/add")
    public ResponseEntity<User> addUser(@RequestBody User newUser){
        userServiceImp.save(newUser);
        return ResponseEntity.status(200).body(newUser);

    }

    @GetMapping( value = "/test" )
    public String test(){
        return "Hello Bahay-LoginServices";
    }

}
