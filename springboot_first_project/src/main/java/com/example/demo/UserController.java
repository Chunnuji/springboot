package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUsers() {
		return "return get request";
	}
	
	@PostMapping
	public String postUsers() {
		return "return post request";
	}
	@DeleteMapping
	public String deleteUsers() {
		return "return delete request";
	}
	@PutMapping
	public String putUsers() {
		return "return put request";
	}

}
