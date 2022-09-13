package com.jeanlima.mvcappdatajpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/")
    public String shwoPage(){
		return "main-menu";
	}


}
