package com.elis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elis.dto.UserDto;
import com.elis.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	@GetMapping
	public List<UserDto> findAllUsers(){
		return userService.findAllUser();
	}
	
}
