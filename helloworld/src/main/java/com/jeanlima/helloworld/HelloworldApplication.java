package com.jeanlima.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloworldApplication {

	@GetMapping("/hello")
	public String hello(){
		return "Olá, mundo do Spring!";
	}

	@Value("${application.name}")
	private String appName;

	 @GetMapping("/getNomeApp")
	 public String getNomeApp(){
		 return appName;
	 } 

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

}
