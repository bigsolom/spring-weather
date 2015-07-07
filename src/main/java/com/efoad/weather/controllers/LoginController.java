package com.efoad.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.efoad.weather.models.User;
import com.efoad.weather.repos.UsersRepository;

@Controller
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	private UsersRepository usersRepository;
	
    @RequestMapping(method=RequestMethod.POST)
    public User login(@RequestBody(required=true) String email, @RequestBody(required=true) String password) {
        User user = usersRepository.findByemailAndPassword(email, password);
//    	model.addAttribute("result", email.equals("efoad@mail.local") && password.equals("password"));
        return user;
    }

}
