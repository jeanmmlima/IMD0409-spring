package com.jeanlima.mvcappdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudante")
public class Estudante {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nome;

    @Column(length = 50)
    private String curso;
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
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public Estudante(String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
    }
    public Estudante() {
    }
    @Override
    public String toString() {
        return "Estudante [id=" + id + ", nome=" + nome + ",curso=" + curso + ", ]";
    }

    
    
    
    
    

    
    
}
