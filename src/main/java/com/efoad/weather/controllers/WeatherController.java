package com.efoad.weather.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.efoad.weather.models.Day;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api/weather")
public class WeatherController {
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Day getTemp(){
//		return "index";
		Day d = new Day();
		RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject("http://api.worldweatheronline.com/free/v2/weather.ashx?q=Cairo&format=json&num_of_days=1&key=b346fbf5b906eef8eef53a6b7fa55", String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
			JsonNode rootNode = mapper.readTree(json);
			JsonNode temp = rootNode.path("data").path("current_condition").path(0).path("temp_C");
			d.setTemp(temp.textValue());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return d;
		
	}
}
