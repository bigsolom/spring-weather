package com.efoad.weather.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
//    private PasswordEncoder passwordEncoder;
	
	@RequestMapping(method=RequestMethod.POST)
	public User create(@RequestBody @Valid User user, BindingResult bindingResult){
//	public User create(@RequestBody(required=true) String email, @RequestBody(required=true) String name, @RequestBody(required=true) String password, @RequestBody(required=true) String mobile){
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(100);
//		User user = new User(name, email, passwordEncoder.encode(password), mobile);
		
		if (bindingResult.hasErrors()){
			user.setErrors(errorsMapping.getErrors(bindingResult.getAllErrors()));
		}else{
			usersRepository.save(user);
			
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
