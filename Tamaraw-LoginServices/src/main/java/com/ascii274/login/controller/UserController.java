package com.ascii274.login.controller;
import com.ascii274.login.entity.User;
import com.ascii274.login.repository.UserRepository;
import com.ascii274.login.service.UserServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger((UserController.class));
    private final UserServiceImp userServiceImp;
    private final UserRepository userRepository;

    public UserController(UserServiceImp userServiceImp, UserRepository userRepository) {
        this.userServiceImp = userServiceImp;
        this.userRepository = userRepository;
    }

    /**
     * Open a form to signup, then redirecto to adduser to insert data
     * @param user
     * @return
     */
    @GetMapping(value="/signup")
    public String signup(User user){
        return "signup";
    }

    /**
     * Create a new user, save it, and redirected to getall.html
     * @param user
     * @return
     */
    @PostMapping(value = "/adduser", consumes = "application/x-www-form-urlencoded")
//    public String addUser(@Valid  User user, Binding result, Model model){
    public String addUser(@Valid  User user, BindingResult result){
        if(result.hasErrors()){
            return "signup";
        }
        user.setDateSignUp(LocalDateTime.now());
        userServiceImp.save(user);
        log.info("User created" + user);
        return "redirect:../admin/getall";
    }


    /**
     * Create a user @param newUser and @return it as ResponseEntity
     */
    @PostMapping(value="/create")
//    @PostMapping(value="/create", consumes = {"multipart/form-data"})
    public ResponseEntity<User> addUserJson(@RequestBody User newUser){
        try{
            newUser.setDateSignUp(LocalDateTime.now());
            userServiceImp.save(newUser);
            return new ResponseEntity<>(newUser,null, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    /**
     * Initial thymeleaf view.
     * @param name
     * @param model
     * @return
     */
    @GetMapping(value = "/test-view")
    public String greeting(@RequestParam(name="helloView", required=false, defaultValue="Hello") String name, Model model) {
        model.addAttribute("helloView","Hello view with thymeleaf");
        return "hello-view";
    }

    /**
     * Initial test message.
     * @return
     */
    @GetMapping( value = "/test-message" )
    public @ResponseBody  String hello(){
        return "Hello, Tamaraw Login Services";
    }

}
