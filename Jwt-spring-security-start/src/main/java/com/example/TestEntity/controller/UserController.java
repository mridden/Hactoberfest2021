package com.example.TestEntity.controller;

import com.example.TestEntity.dto.AuthenticationRequest;
import com.example.TestEntity.entity.UserEntity;
import com.example.TestEntity.repositery.UserRepositery;
import com.example.TestEntity.service.EmailSenderService;
import com.example.TestEntity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    //userRegister
    //userLogin
    //userUpdate
    //userDelete
    //userRead
    //usersRead

    @Autowired
    private UserService userService;

    @Autowired
    UserRepositery userRepositery;

    @Autowired
    EmailSenderService emailSenderService;

    @RequestMapping({"/check"})
    public String checkApi(){
        return "Spring security jwt is working";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
       return this.userService.loginService(authenticationRequest);
    }

    @GetMapping(value = "/passwordforget/{userName}")
    public ResponseEntity<?> forgetPassword(@PathVariable("userName") String username){
        String msg=this.emailSenderService.sendSimpleEmail(username);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping(value = "/admin/getAllUsers")
    public List<UserEntity> getAllUsers(Authentication authentication){
         System.out.println(authentication);
        List<UserEntity> userEntityList =this.userRepositery.findAll();
        return userEntityList;
    }

//    @GetMapping(value = "/getAllUsers")
//    public StudentEntity getStudent(){
//        return this.userRepositery.findById(1).get().getStudentEntity();
//    }

}
