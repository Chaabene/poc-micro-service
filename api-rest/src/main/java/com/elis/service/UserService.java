package com.elis.service;

import java.util.List;

import com.elis.dto.UserDto;

public interface UserService {

	List<UserDto> findAllUser();

	UserDto findUserById(Long userId);

	UserDto saveUser(UserDto userDto);

	void deleteUser(Long userId);

	void updateUser(Long userId, UserDto userDto);

}
