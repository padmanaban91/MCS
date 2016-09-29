package com.citi.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.citi.scm.Login;

@Controller
public class SCMavenController {

	@RequestMapping("/")
	public String index(Model model, @ModelAttribute("login") Login login) {
		if(login.getUsername() != null && !login.getUsername().isEmpty() &&
				login.getPassword() != null && !login.getPassword().isEmpty()) {
			model.addAttribute("value", "Login Done");
			return "welcome";
		} else {
			model.addAttribute("value", "Login Failed");
			return "login";
		}
		
	}

}
