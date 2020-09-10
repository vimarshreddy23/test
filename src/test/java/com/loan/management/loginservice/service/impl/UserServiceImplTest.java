package com.loan.management.loginservice.service.impl;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.loan.management.loginservice.dao.UserDao;
import com.loan.management.loginservice.dto.LoginDto;
import com.loan.management.loginservice.dto.SignUpDto;
import com.loan.management.loginservice.model.User;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@MockBean
	private UserDao userDao;

	@Before
	public void init() throws JsonParseException, JsonMappingException, IOException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void get_signup() {
		User user = new User();
		user.setUsername("user");
		user.setPassword("pass");
		Mockito.when(userDao.save(Mockito.any(User.class))).thenReturn(user);
		SignUpDto signUpDto = new SignUpDto();
		signUpDto.setUsername("user");
		signUpDto.setPassword("pass");
		userServiceImpl.signUp(signUpDto);
	}

	@Test
	public void getLogin() {
		User user = new User();
		user.setUsername("user");
		user.setPassword("pass");
		Mockito.when(userDao.findByUsername(Mockito.anyString())).thenReturn(user);
		LoginDto loginDto = new LoginDto();
		loginDto.setPassword("pass");
		loginDto.setUsername("user");
		userServiceImpl.login(loginDto);

	}
}
