package com.jeanlima.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanlima.helloworld.model.Aluno;

//@RestController
@RestController
@RequestMapping("/primeiro")
public class MeuPrimeiroController {

    @GetMapping("/hello")
	public String hello(){
		return "Olá, mundo do Spring! Saudação do primeiro controller!";
	}

	@Value("${application.name}")
	private String appName;

	@GetMapping("/getNomeApp")
	 public String getNomeApp(){
		 return appName;
	 } 

    @Autowired
    private Aluno aluno;


    @GetMapping("/getAluno")
	 public String getAluno(){
        this.aluno.setNome("Aluno Fulano");
        this.aluno.setCurso("Eng Software");

		return aluno.toString();
	 } 
    
}
