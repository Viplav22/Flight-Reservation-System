package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePageController {
	public WelcomePageController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	
	//add a req handling method to provide a welcome page (index)
	@GetMapping("/")
	public String provideWelcomePage() {
		System.out.println("in welcome page");
		return "/welcome";
		//Actual view name reted by V.R : /WEB-INF/views/welcome.jsp
	}

}
