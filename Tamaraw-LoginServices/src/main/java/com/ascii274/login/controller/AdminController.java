package com.ascii274.login.controller;

import com.ascii274.login.entity.User;
import com.ascii274.login.repository.UserRepository;
import com.ascii274.login.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(value = "admin/")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger((UserController.class));
    private final UserServiceImp userServiceImp;
    private final UserRepository userRepository;

    public AdminController(UserServiceImp userServiceImp, UserRepository userRepository) {
        this.userServiceImp = userServiceImp;
        this.userRepository = userRepository;
    }

    /**
     * Return all users
     * @param model
     * @return
     */
    @GetMapping(value = "/getall")
    public String getAllUsers(Model model){
        model.addAttribute("allusers", userServiceImp.getAllUsers());
        return "getall";
    }

    /**
     * Search by mobile or mail
     * @param mailMobile
     * @return as jsonformat
     */
    @GetMapping(path = "/search/mail-mobile/{mailMobile}")
    public @ResponseBody ResponseEntity<Optional<User>> search(@PathVariable("mailMobile") String mailMobile){
        Optional<User> userFound =  userServiceImp.getUserByMailMobile(mailMobile);
        return ResponseEntity.status(200)
                .body(userFound);
    }

    @GetMapping(value = "/test-message")
    public @ResponseBody String helloAdmin(){
        return "Hello, admin";
    }

}
