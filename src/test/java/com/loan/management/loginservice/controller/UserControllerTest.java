package com.loan.management.loginservice.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loan.management.loginservice.LoanManagementLoginServiceApplication;
import com.loan.management.loginservice.dto.ApiResponse;
import com.loan.management.loginservice.dto.LoginDto;
import com.loan.management.loginservice.service.UserService;
import com.loan.management.loginservice.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { LoanManagementLoginServiceApplication.class })

public class UserControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private UserService userService;

	@MockBean
	private UserServiceImpl userServiceImpl;
	
	private ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);


	LoginDto loginDto;

	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		loginDto = new LoginDto();
		loginDto.setPassword("password");
		loginDto.setUsername("user");

	}

	@Test
	public void login_IsValid_Request() throws Exception {
		ApiResponse response = new ApiResponse(200, "Success", "Hello");
		when(userService.login((LoginDto) any(LoginDto.class))).thenReturn(response);
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(loginDto)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
	}

}