package com.citi.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citi.scm.Login;

@Controller
public class SCMavenController {

	@RequestMapping(value = "/")
	public String index() {
		
		return "login";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("login") Login login) {
		if(login.getUsername() != null && !login.getUsername().isEmpty() &&
				login.getPassword() != null && !login.getPassword().isEmpty()) {
			System.out.println("=== " + login.getPassword());
			model.addAttribute("value", "Login Done");
			return "welcome";
		} else {
			
			model.addAttribute("failMessage", "Login Failed");
			model.addAttribute("value", "Login Failed");
			return "login";
		}
		
	}

}
