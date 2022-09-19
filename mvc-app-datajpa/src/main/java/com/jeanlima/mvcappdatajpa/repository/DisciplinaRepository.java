package com.jeanlima.mvcappdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeanlima.mvcappdatajpa.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer>{

    
    
}
