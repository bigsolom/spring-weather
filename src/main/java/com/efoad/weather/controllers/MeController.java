package com.efoad.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.efoad.weather.models.User;
import com.efoad.weather.services.AuthenticationService;

@Controller
@RequestMapping("/api/me")
public class MeController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public User getCurrentUser(){
		return authenticationService.getCurrentUser();
	}
}
