package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Value("${name.user}")
	private String name;

	@Value("${roll.number}")
	private String number;

	@GetMapping("/details")
	public String getDetails() {
        return name+"-"+number;
	}
	
	@GetMapping
	public String getUsers() {
		return "hi, CJ";
	}

}
