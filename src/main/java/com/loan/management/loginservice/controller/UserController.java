package com.loan.management.loginservice.controller;

import com.loan.management.loginservice.dto.ApiResponse;
import com.loan.management.loginservice.dto.LoginDto;
import com.loan.management.loginservice.dto.SignUpDto;
import com.loan.management.loginservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ApiResponse signUp(@RequestBody SignUpDto signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }
}
