package com.jeanlima.mvcappdatajpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeanlima.mvcappdatajpa.model.Estudante;


@Service
public interface EstudanteService {

    

    public void salvarEstudante(Estudante estudante);
    public void deletarEstudante(Estudante estudante);
    public Estudante getEstudanteById(Integer id);
    public List<Estudante> getListaEstudante();



    
    
    
}
