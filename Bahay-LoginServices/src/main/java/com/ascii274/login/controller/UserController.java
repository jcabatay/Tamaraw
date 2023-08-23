package com.ascii274.login.controller;

import com.ascii274.login.entity.User;
import com.ascii274.login.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger((UserController.class));

//    @Autowired
    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping(value="/add")
    public ResponseEntity<User> addUser(@RequestBody User newUser){
        userServiceImp.save(newUser);
        return ResponseEntity.status(200).body(newUser);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userServiceImp.getAllUsers();
        return ResponseEntity.status(200).body(users);

    }

    @GetMapping(path = "/search/id/{id}")
    public @ResponseBody ResponseEntity<Optional<User>> search(@PathVariable("id") Long userId){
        Optional<User> userFound = Optional.of(new User());
        userFound = userServiceImp.getUserById(userId);
        return ResponseEntity.status(200).body(userFound);
    }

    @GetMapping(path = "/search/userid/{userId}")
    public @ResponseBody ResponseEntity<Optional<User>> searchUserId(@PathVariable("userId") String userId){
        Optional<User> userIdFound = Optional.of(new User());
        userIdFound = userServiceImp.getUserByUserId(userId);
        return ResponseEntity.status(200).body(userIdFound);
    }


    @GetMapping( value = "/test-message" )
    public String hello(){
        return "Hello, Bahay Login Services";
    }

}
