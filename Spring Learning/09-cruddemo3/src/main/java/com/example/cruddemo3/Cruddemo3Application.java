package com.example.cruddemo3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cruddemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemo3Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner ->{
			System.out.println("Hello!!!!!!!!!!!!");
		};
	}

}
