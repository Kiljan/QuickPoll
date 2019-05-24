package com.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeWebController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloHome() {
		return "home";
	}
	
}
