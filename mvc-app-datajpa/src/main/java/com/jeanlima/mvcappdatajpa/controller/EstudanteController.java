package com.jeanlima.mvcappdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeanlima.mvcappdatajpa.model.Estudante;
import com.jeanlima.mvcappdatajpa.service.EstudanteService;


@Controller
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    @Qualifier("estudanteServiceImpl")
    EstudanteService estudanteService;


    @RequestMapping("/showForm")
    public String showFormEstudante(Model model){

        model.addAttribute("estudante", new Estudante());
        return "estudante/formEstudante";
    }

    @RequestMapping("/addEstudante")
    public String showFormEstudante(@ModelAttribute("estudante") Estudante estudante,  Model model){

        Estudante novoEstudante = estudanteService.salvarEstudante(estudante);


        model.addAttribute("estudante", novoEstudante);
        return "estudante/paginaEstudante";
    }

    @RequestMapping("/getListaEstudantes")
    public String showListaEstudante(Model model){

        List<Estudante> estudantes = estudanteService.getListaEstudante();
        model.addAttribute("estudantes",estudantes);
        return "estudante/listaEstudantes";

    }

    @GetMapping("/getEstudanteById/{id}")
    public String getEstudanteById( @PathVariable Integer id, Model model){

        Estudante estudante = estudanteService.getEstudanteById(id);
        model.addAttribute("estudante",estudante);
        return "estudante/paginaEstudante";
    }

    
    
}
