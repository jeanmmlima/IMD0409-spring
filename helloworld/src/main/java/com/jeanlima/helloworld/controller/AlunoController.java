package com.jeanlima.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeanlima.helloworld.model.Aluno;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private Aluno aluno;


    @GetMapping("/getAluno")
	 public String getAluno(){
        this.aluno.setNome("Aluno Fulano");
        this.aluno.setCurso("Eng Software");

		return aluno.toString();
	 } 

    @GetMapping("/setNomeAluno/{nomeAluno}")
    public String setNomeAluno(@PathVariable String nomeAluno){
        this.aluno.setNome(nomeAluno);
        this.aluno.setCurso("Eng Software");
        return aluno.toString();
    } 

    @GetMapping("/getAlunoById/{idAluno}")
	 public String getAlunoById(@PathVariable int idAluno){

		return aluno.getListaAlunos()[idAluno-1].toString();
	 }
    
}
