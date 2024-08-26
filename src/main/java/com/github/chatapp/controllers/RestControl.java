package com.github.chatapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {

	@GetMapping("")
	public String hello() {
		return "Hello World";
	}
}
