package com.jeanlima.helloworld.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Aluno {

    private Integer id;
    private String nome;
    private String curso;


    
    public Aluno() {
    }

    public Aluno(Integer id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    @Override
    public String toString() {
        return "Aluno [curso=" + curso + ", nome=" + nome + "]";
    }

    private static final Aluno[] listaAlunos = {
        new Aluno(1,"João Maria", "BTI"),
        new Aluno(2,"José Silva", "BTI"),
        new Aluno(3,"Maria José", "BTI"),
    };


    public Aluno[] getListaAlunos() {
        return listaAlunos;
    }

    
    
    
}
