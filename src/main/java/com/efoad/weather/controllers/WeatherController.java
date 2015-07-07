package com.efoad.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/weather")
public class WeatherController {
	@RequestMapping(method=RequestMethod.GET)
	public String getTemp(){
		return "index";
	}
}
