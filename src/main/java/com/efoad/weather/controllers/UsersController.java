package com.efoad.weather.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.efoad.weather.models.User;
import com.efoad.weather.repos.UsersRepository;

@RestController
@RequestMapping("/users/")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
//	@Autowired 
//    private PasswordEncoder passwordEncoder;
	@RequestMapping(method=RequestMethod.POST)
	public User create(@RequestBody(required=true) String email, @RequestBody(required=true) String name, @RequestBody(required=true) String password, @RequestBody(required=true) String mobile){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(100);
		User user = new User(name, email, passwordEncoder.encode(password), mobile);
		usersRepository.save(user);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getUsers(){
		List<User> users = new ArrayList<User>();
		usersRepository.findAll().forEach((user)->users.add(user));
		return users;
	
	}
}
