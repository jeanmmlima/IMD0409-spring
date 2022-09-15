package com.jeanlima.mvcappdatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jeanlima.mvcappdatajpa.model.Estudante;
import com.jeanlima.mvcappdatajpa.repository.EstudanteRepository;

@Component
public class EstudanteServiceImpl implements EstudanteService{

    @Autowired
    EstudanteRepository estudanteRepository;

    @Override
    public Estudante salvarEstudante(Estudante estudante) {
        
        return estudanteRepository.save(estudante);
    }

    @Override
    public void deletarEstudante(Estudante estudante) {
        estudanteRepository.delete(estudante);
        
    }

    @Override
    public Estudante getEstudanteById(Integer id) {
        return estudanteRepository.findById(id).map(estudante -> {
            return estudante;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Estudante> getListaEstudante() {
        return estudanteRepository.findAll();
    }
    
}
