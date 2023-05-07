package com.SpringSecOauth2pratice.code.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BasicController {

	
	@GetMapping(value="/getmessage")
	public String getMessage()
	{
		return "message";
		
	}
}
