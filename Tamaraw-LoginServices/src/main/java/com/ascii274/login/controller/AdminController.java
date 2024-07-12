package com.ascii274.login.controller;

import com.ascii274.login.entitydto.dto.UserResponseDto;
import com.ascii274.login.entitydto.entity.User;
import com.ascii274.login.repository.UserRepository;
import com.ascii274.login.service.UserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
     * Listing all data, showing it in getall.HTML
     * @param model
     * @return
     */
    @GetMapping(value = "/getall")
    public String getAllUsers(Model model){
        model.addAttribute("allusers", userServiceImp.getAllUsers());
        return "getall";
    }

    /**
     * Hello message.
     * @return
     */
    @GetMapping(value = "/test-message")
    public @ResponseBody String helloAdmin(){
        return "Hello, admin";
    }


    /* > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > >
     *      JSON RETURN DATA
     * > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > >  */

    /**
     * Return a list searching by mail or mobile number
     * @param mailMobile
     * @return list
     */
    @GetMapping(path = "/search/{mailMobile}")
    public @ResponseBody ResponseEntity<List<UserResponseDto>> search(@PathVariable("mailMobile") String mailMobile){
        List<UserResponseDto> userFound =  userServiceImp.getUserByMailMobile(mailMobile);
        return ResponseEntity.status(200)
                .body(userFound);
    }

    /**
     * List all users, showing it as JSON
     * @return
     */
    @GetMapping(value = "/getallusers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServiceImp.getAllUsers();
        return ResponseEntity.status(200).body(users);
    }
}
