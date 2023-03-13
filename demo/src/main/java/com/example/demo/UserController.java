package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@GetMapping
	public String getUsers(@RequestParam(value="page") int pageone,@RequestParam(value="limit") int pagelast) {
		return "return get request"+pageone+"limit"+pagelast;
	}
	
//	@GetMapping()
//	public String getUsers() {
//		return "return get request";
//	}
	
	@GetMapping(path= "/{userID}")
	public String getUsers(@PathVariable String userID) {
		return "return get with userId request";
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
