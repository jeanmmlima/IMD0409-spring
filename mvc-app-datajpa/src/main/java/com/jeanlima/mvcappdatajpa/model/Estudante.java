package com.jeanlima.mvcappdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estudante")
public class Estudante {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Estudante(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }
        
    public Estudante(String nome) {
        this.nome = nome;
    }
    public Estudante() {
    }
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    

   
    @Override
    public String toString() {
        return "Estudante [curso=" + curso + ", id=" + id + ", nome=" + nome + "]";
    }
    

    
    
    
    
    

    
    
}
