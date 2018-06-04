package com.notarius.urlshortener.urlshortener.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
}
