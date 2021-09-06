package com.kardex.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kardex.dto.GenericAnswerDto;
import com.kardex.services.UserService;

public class UserControllerTest {

	public static final String GENERIC_ANSWER = "Exitoso.";
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	private GenericAnswerDto genericAnswer;
	private String user;
	private String userEmail;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		setResponseGenericAnswer();
		setNewUser();
		userEmail = "admin@correo.com";
		Mockito.when(userService.createUser(user)).thenReturn(genericAnswer);
		Mockito.when(userService.findUser(userEmail)).thenReturn(genericAnswer);
	}
	
	@Test
	public void createUser() {
		ResponseEntity<?> response = userController.createUser(user);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody());
	}

	@Test
	public void getUser() {
		ResponseEntity<?> response = userController.getUser(userEmail);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody());
	}
	
	public void setResponseGenericAnswer() {
		genericAnswer = new GenericAnswerDto("1", GENERIC_ANSWER, null);
	}

	public void setNewUser() {
		user = "{data: {\r\n"
				+ "        \"userName\": \"admin31\",\r\n"
				+ "        \"userEmail\": \"adm3i1n@correo.com\",\r\n"
				+ "        \"password\": \"1234\"\r\n"
				+ "    }\r\n"
				+ "}";
	}

}
