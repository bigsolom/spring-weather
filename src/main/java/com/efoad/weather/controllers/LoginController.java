package com.efoad.weather.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.efoad.weather.controllers.requests.LoginRequest;
import com.efoad.weather.models.User;
import com.efoad.weather.repos.UsersRepository;
import com.efoad.weather.services.ErrorMappingService;

@Controller
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ErrorMappingService errorMappingService;
	
    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody @Valid LoginRequest loginRequest, BindingResult bindingResult) {
    	User user = new User();
    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	if (bindingResult.hasErrors()){
        	user.setErrors(errorMappingService.getErrors(bindingResult.getAllErrors()));
        }else{
        	//TODO: move the find user by password logic to the model/ repository
        	User dbUser = usersRepository.findByemail(loginRequest.getEmail());
        	
        	if (null != dbUser && passwordEncoder.matches(loginRequest.getPassword(), dbUser.getPassword())){
        		user = dbUser;
        	}else{
        		bindingResult.addError(new ObjectError("User", "Invalid Credentials"));
        		user.setErrors(errorMappingService.getErrors(bindingResult.getAllErrors()));
        	}
        }
        return user;
    }

}
