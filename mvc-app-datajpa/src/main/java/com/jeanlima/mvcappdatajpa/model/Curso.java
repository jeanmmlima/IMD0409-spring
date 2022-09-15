package com.jeanlima.mvcappdatajpa.model;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String descricao;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private Set<Estudante> estudantes; 


    public Curso() {
    }
    
    public Curso(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Curso [descricao=" + descricao + ", id=" + id + "]";
    }

    public Set<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(Set<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
    
    
    
    
}
