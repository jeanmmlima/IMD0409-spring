package com.jeanlima.mvcappdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeanlima.mvcappdatajpa.model.Disciplina;
import com.jeanlima.mvcappdatajpa.model.Estudante;

public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer>{

    @Query(value="SELECT d FROM Disciplina d JOIN d.estudantes e where e.id =:id")
    List<Disciplina> findAllByEstudanteId(@Param("id") Integer id);
    
}
