package com.jeanlima.mvcappdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeanlima.mvcappdatajpa.model.Estudante;


public interface EstudanteRepository extends JpaRepository<Estudante,Integer>{

    

}
