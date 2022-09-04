package com.jeanlima.mvcapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/")
    public String shwoPage(){
		return "main-menu";
	}

	@RequestMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}

	@RequestMapping("/processaForm")
	public String processForm(HttpServletRequest request, Model model){

		String paramNome = request.getParameter("nome");
		model.addAttribute("nome", paramNome);
		return "helloworld";
	}

	@RequestMapping("/processaFormDois")
	public String processFormDois(@RequestParam("nome") String nome, Model model){

		nome = nome.toUpperCase();
		String result = "Olá! " + nome;
		model.addAttribute("msg", result);
		return "helloworld";
	}

}
