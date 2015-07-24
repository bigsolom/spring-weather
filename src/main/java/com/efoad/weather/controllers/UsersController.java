package com.efoad.weather.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efoad.weather.models.User;
import com.efoad.weather.repos.UsersRepository;
import com.efoad.weather.services.ErrorMappingService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ErrorMappingService errorsMapping;
//	@Autowired 
//    private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(method=RequestMethod.POST)
	public User create(@RequestBody @Valid User user, BindingResult bindingResult){

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		if (bindingResult.hasErrors()){
			user.setErrors(errorsMapping.getErrors(bindingResult.getAllErrors()));
		}else{
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setToken(UUID.randomUUID().toString());
			user = usersRepository.save(user);	
//			user.se
		}
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		usersRepository.findAll().forEach((user)->users.add(user));
		return users;
	
	}
}
