package com.elis.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.elis.dto.UserDto;
import com.elis.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<UserDto> findAllUsers() {
		return userService.findAllUser();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity saveUser(@RequestBody UserDto userDto) {
		UserDto userSaved = userService.saveUser(userDto);
		// location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("{id}")
	public EntityModel<UserDto> findUserById(@PathVariable("id") long idUser) {
		UserDto user = userService.findUserById(idUser);
		// Hateoas
		EntityModel<UserDto> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkToBuilder = WebMvcLinkBuilder
				                          .linkTo(WebMvcLinkBuilder.methodOn(this.getClass())
				                          .findAllUsers());
		resource.add(linkToBuilder.withRel("all-users"));
		return resource;
	}

	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
	}

	@PutMapping("{id}")
	public void updateUser(@PathVariable("id") long idUser, @RequestBody UserDto user) {

		userService.updateUser(idUser, user);
	}

}
