package com.elis.config;


import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.elis.model.User;
import com.elis.repository.UserRepository;

@Configuration
public class configuration {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args->{
			User user = new User();
			user.setAddress("villeJuif");
			user.setUsername("Aymen chaabene");
			
			User user2 = new User();
			user.setAddress("villeJuif 2");
			user.setUsername("Aymen chaabene 2");
			userRepository.saveAll(Arrays.asList(user,user2))	;		
		};
	}

}
