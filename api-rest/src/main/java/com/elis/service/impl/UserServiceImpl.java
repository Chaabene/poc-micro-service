package com.elis.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elis.dto.UserDto;
import com.elis.model.User;
import com.elis.repository.UserRepository;
import com.elis.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<UserDto> findAllUser() {
		List<User> users = userRepository.findAll();
		if (CollectionUtils.isEmpty(users)) {
			return null;
		}
		return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto findUserById(Long userId) {
		return userRepository.findById(userId).map(user -> modelMapper.map(user, UserDto.class)).orElseThrow(() -> {
			throw new IllegalStateException("User with id " + userId + " does not exist ");
		});

	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Long userId) {
		boolean exists = userRepository.existsById(userId);
		if (!exists) {
			throw new IllegalStateException("User with id " + userId + " does not exist ");
		}
		userRepository.deleteById(userId);
	}

	@Override
	public void updateUser(Long userId, final UserDto userDto) {
		User user = userRepository.findById(userId).orElseThrow(() -> {
			throw new IllegalStateException("User with id " + userId + " does not exist ");
		});
		userDto.setId(userId);
		modelMapper.map(userDto, user);
	}

}
