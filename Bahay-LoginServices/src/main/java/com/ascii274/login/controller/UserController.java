package com.ascii274.login.controller;

import com.ascii274.login.entity.User;
import com.ascii274.login.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
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
//        return ResponseEntity.status(200).body(newUser); //
        return new ResponseEntity<>(newUser,null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getall")
    public String getAllUsers(Model model){
        model.addAttribute("allusers", userServiceImp.getAllUsers());
        return "getall";
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

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/test-view")
    public String greeting(@RequestParam(name="helloView", required=false, defaultValue="Hello") String name, Model model) {
        model.addAttribute("helloView","Hello view with thymeleaf");
        return "hello-view";
    }

    @GetMapping( value = "/test-message" )
    public String hello(){
        return "Hello, Bahay Login Services";
    }

}
