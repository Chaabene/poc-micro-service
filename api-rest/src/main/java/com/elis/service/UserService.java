package com.elis.service;

import java.util.List;
import java.util.Optional;

import com.elis.dto.UserDto;
import com.elis.model.User;

public interface UserService {

	List<UserDto> findAllUser();

	UserDto findUserById(Long id);

	User saveUser(UserDto userDto);
	
	

}
