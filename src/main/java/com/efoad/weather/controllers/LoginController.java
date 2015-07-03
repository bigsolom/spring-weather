package com.efoad.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(method=RequestMethod.GET)
    public String login(@RequestParam(value="email", required=true) String email,@RequestParam(value="password", required=true) String password, Model model) {
        model.addAttribute("result", email.equals("efoad@mail.local") && password.equals("password"));
        return "login";
    }

}
