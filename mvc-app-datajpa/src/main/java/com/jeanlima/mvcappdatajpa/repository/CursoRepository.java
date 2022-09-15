package com.jeanlima.mvcappdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanlima.mvcappdatajpa.model.Curso;

public interface CursoRepository extends JpaRepository<Curso,Integer>{
    
}
