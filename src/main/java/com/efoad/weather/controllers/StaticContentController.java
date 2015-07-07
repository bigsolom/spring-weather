package com.efoad.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//find a better way than this to serve angular 
@RequestMapping({"/", "/start"})
public class StaticContentController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
	    return "forward:/index.html";
	}
}
