package com.loan.management.loginservice.service.impl;

import com.loan.management.loginservice.dao.UserDao;
import com.loan.management.loginservice.dto.ApiResponse;
import com.loan.management.loginservice.dto.LoginDto;
import com.loan.management.loginservice.dto.SignUpDto;
import com.loan.management.loginservice.model.User;
import com.loan.management.loginservice.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ApiResponse signUp(SignUpDto signUpDto) {
        validateSignUp(signUpDto);
        User user = new User();
        BeanUtils.copyProperties(signUpDto, user);
        userDao.save(user);
        return new ApiResponse(200, "success", user);
    }

    @Override
    public ApiResponse login(LoginDto loginDto) {
        User user = userDao.findByUsername(loginDto.getUsername());
        if(user == null) {
            throw new RuntimeException("User already exist or data not present in DB");
        }
        if(!user.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return new ApiResponse(200, "Login success", user) ;

    }

    private void validateSignUp(SignUpDto signUpDto) {
    }
}
