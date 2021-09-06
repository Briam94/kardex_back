package com.kardex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kardex.services.UserService;
import com.kardex.utils.Constans;

@CrossOrigin
@RestController
@RequestMapping(Constans.USER_REQUEST_MAPPING)
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = Constans.USER_CREATE, method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody String trama) {
    	return new ResponseEntity<>(userService.createUser(trama), HttpStatus.OK);
    }

    @RequestMapping(value = Constans.LOGIN, method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody String trama) {
    	return new ResponseEntity<>(userService.login(trama), HttpStatus.OK);
    }

    @RequestMapping(value = Constans.USER_GET, method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@RequestParam(name = "email") String trama) {
    	return new ResponseEntity<>(userService.findUser(trama), HttpStatus.OK);
    }

}
