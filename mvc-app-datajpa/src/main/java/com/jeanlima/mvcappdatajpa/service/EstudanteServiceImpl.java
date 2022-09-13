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
    public void salvarEstudante(Estudante estudante) {
        
        estudanteRepository.salvar(estudante);
    }

    @Override
    public void deletarEstudante(Estudante estudante) {
        estudanteRepository.deletar(estudante);
        
    }

    @Override
    public Estudante getEstudanteById(Integer id) {
        return estudanteRepository.obterPorId(id);
    }

    @Override
    public List<Estudante> getListaEstudante() {
        return estudanteRepository.obterTodos();
    }
    
}
