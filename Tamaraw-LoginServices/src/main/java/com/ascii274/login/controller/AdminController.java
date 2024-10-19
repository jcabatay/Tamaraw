package com.ascii274.login.controller;


import com.ascii274.login.entitydto.dto.UserResponseDto;
import com.ascii274.login.entitydto.dto.UserSearchDto;
import com.ascii274.login.entitydto.entity.User;
import com.ascii274.login.repository.UserRepository;
import com.ascii274.login.service.UserServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger((UserController.class));
    private final UserServiceImp userServiceImp;
//    private final UserRepository userRepository;

    public AdminController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
//        this.userRepository = userRepository;
    }

    /**
     * Call form-search to find mail_mobile ...
     * @param userSearchDto
     * @return
     */
    @GetMapping(value="/search")
    public String search(UserSearchDto userSearchDto){
        return "search";
    }

    /**
     * List all data userSearchDto found, showing it in found.html
     * @param userSearchDto
     * @param model
     * @return
     */
    @PostMapping(value = "/found")
    public String find(@Valid UserSearchDto userSearchDto, Model model){
        model.addAttribute("usersMailMobileFounds", userServiceImp.getUserByMailMobile(userSearchDto.getMailMobile()));
        log.info("searching " + userSearchDto.toString());
        return "found";
    }

    /**
     * Listing all data, showing it in getall.html
     * @param model
     * @return
     */
//    @ExceptionHandler(value = UserException.class)
    @GetMapping(value = "/getall")
    public String getAllUsers(Model model, UserSearchDto userSearchDto) throws Exception{
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
    @GetMapping(path = "/search2/{mailMobile}")
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
