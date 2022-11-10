package com.jeanlima.springrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringRestApiApplication extends SpringBootServletInitializer { //deixa de ser uma aplicação standalone e passar a ser uma web (empacotamento WAR)

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);

		
	}

}
