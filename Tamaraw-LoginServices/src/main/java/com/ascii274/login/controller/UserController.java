package com.ascii274.login.controller;

import com.ascii274.login.entitydto.dto.UserCreationDto;
import com.ascii274.login.entitydto.entity.User;
import com.ascii274.login.exception.UserException;
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
import java.text.ParseException;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger((UserController.class));
    private final UserServiceImp userServiceImp;
//    private final UserRepository userRepository;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
//        this.userRepository = userRepository;
    }

    @GetMapping(value="/error")
    public UserException error() throws Exception{
        log.info("throw userException");
        return new UserException("Dentro user exception");
//        return "error";
    }

//    @ExceptionHandler(UserException.class)
//    public String error2(){
//        log.error("Errror in Exception handler");
//        return "error";
//    }

    /**
     * Show a form to fillup, then is redirect to /adduser to insert data user
     * @param user
     * @return
     */
    @GetMapping(value="/signup")
    public String signup(User user){
        return "signup";
    }

    /**
     * Create a new user, from a form signup.
     * @param userCreationDto
     * @param result
     * @return
     */
    @PostMapping(value = "/adduser", consumes = "application/x-www-form-urlencoded")
    public String addUser(@Valid  UserCreationDto userCreationDto, BindingResult result){
        if(result.hasErrors()){
            return "signup";
        }
        userServiceImp.save(userCreationDto);
        log.info("UserCreationDto created" + userCreationDto);
        return "redirect:../admin/getall";
    }

    /**
     * Show index.html
     * @return
     */
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


    /* > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > >
     *      JSON RETURN DATA
     * > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > > >  */




    @PostMapping(value="/add")
    public ResponseEntity<UserCreationDto> addUser(@RequestBody UserCreationDto userCreationDto) throws ParseException {
        User user=userServiceImp.save(userCreationDto);
        log.info("User created " + userCreationDto);
        return ResponseEntity.status(200).body(userCreationDto);
    }

    /**
     * Create an User with
     * @param userCreationDto
     * @return
     */
    @PostMapping(value="/create")
    public ResponseEntity<User> createUser(@RequestBody UserCreationDto userCreationDto){
        try{
            User user=userServiceImp.save(userCreationDto);
            log.info("UserCreationDto created" + userCreationDto);
            return new ResponseEntity<>(user,null, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
