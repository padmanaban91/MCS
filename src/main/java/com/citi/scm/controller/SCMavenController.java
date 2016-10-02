package com.citi.scm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citi.scm.Login;
import com.citi.scm.service.SCMService;

@Controller
public class SCMavenController {
	
	@Autowired
	SCMService scmService;

	@RequestMapping(value = "/")
	public String index() {
		
		return "login";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("login1") Login login1) {
		if(login1.getUsername() != null && !login1.getUsername().isEmpty() &&
				login1.getPassword() != null && !login1.getPassword().isEmpty()) {
			System.out.println("=== " + login1.getPassword());
			model.addAttribute("value", "Login Done");
			return "welcome";
		} else {
			
			model.addAttribute("failMessage", "Login Failed");
			model.addAttribute("value", "Login Failed");
			return "login";
		}
		
	}
	
	@RequestMapping("/start")
	public String startWorkflow(Login name, Model model) {
		try {
			Map<String, Object> inputMap = new HashMap<String, Object>();
			inputMap.put("userName", name.getUsername());
			scmService.startWorkflow(inputMap);
			model.addAttribute("value", "Workflow Executed");
		} catch (Exception e) {
			model.addAttribute("value", "Workflow Execution Failed");
		}		
		return "complete";
	}
	
	@RequestMapping("/complete")
	public String completeWorkflow(Login name, Model model) {
		try {			
			Map<String, Object> inputMap = new HashMap<String, Object>();
			inputMap.put("userName", name.getUsername());
			scmService.completeWorkflow(inputMap);
			model.addAttribute("value", "Workflow Completed");
			return "welcome";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("value", "Workflow Completion Failed");
			return "complete";
		}		
	}

}
