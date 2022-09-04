package com.jeanlima.mvcapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jeanlima.mvcapp.model.Estudante;

@Component
public class EstudanteServiceImpl implements EstudanteService{

    public List<Estudante> estudantes = new ArrayList<Estudante>();    

    @Override
    public void salvarEstudante(Estudante estudante) {
        System.out.println(estudante.toString());
        try{
            this.estudantes.add(estudante);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
        
        
    }

    @Override
    public void deletarEstudante(Estudante estudante) {
        
        this.estudantes.remove(estudante);
        
    }

    @Override
    public Estudante getEstudanteById(Integer id) {
        for (Estudante estudante : estudantes) {
            if(estudante.getId() == id){
                return estudante;
            }
        }
        return null;
    }

    @Override
    public List<Estudante> getListaEstudante() {
        return this.estudantes;
    }

    
}
