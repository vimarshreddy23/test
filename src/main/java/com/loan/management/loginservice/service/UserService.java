package com.loan.management.loginservice.service;

import com.loan.management.loginservice.dto.ApiResponse;
import com.loan.management.loginservice.dto.LoginDto;
import com.loan.management.loginservice.dto.SignUpDto;

public interface UserService {

    ApiResponse signUp(SignUpDto signUpDto);

    ApiResponse login(LoginDto loginDto);
}
