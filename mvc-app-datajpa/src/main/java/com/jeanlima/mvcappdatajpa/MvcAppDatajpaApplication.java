package com.jeanlima.mvcappdatajpa;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jeanlima.mvcappdatajpa.model.Curso;
import com.jeanlima.mvcappdatajpa.model.Disciplina;
import com.jeanlima.mvcappdatajpa.model.Estudante;
import com.jeanlima.mvcappdatajpa.repository.CursoRepository;
import com.jeanlima.mvcappdatajpa.repository.DisciplinaRepository;
import com.jeanlima.mvcappdatajpa.repository.EstudanteRepository;

@SpringBootApplication
public class MvcAppDatajpaApplication {

	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	EstudanteRepository estudanteRepository;

    @Autowired
    DisciplinaRepository disciplinaRepository;

	@Bean
	public CommandLineRunner init(){
		return args -> {
			System.out.println("Cadastrando cursos");

			cursoRepository.save(new Curso("BTI"));
            cursoRepository.save(new Curso("Engenharia de Computação"));
            cursoRepository.save(new Curso("Engenharia de Software"));
            cursoRepository.save(new Curso("Ciência da Computação"));

            System.out.println("Cadastrando Disciplinas");
            disciplinaRepository.save(new Disciplina("Desenvolvimento Web I", "IMD0408"));
            disciplinaRepository.save(new Disciplina("Desenvolvimento Web II", "IMD0409"));
            disciplinaRepository.save(new Disciplina("Desenvolvimento para Dispositivos Móveis", "IMD0509"));

            System.out.println("Cursos cadastrados");
            List<Curso> cursos = cursoRepository.findAll();
            cursos.forEach(System.out::println);

            System.out.println("Disciplinas cadastradas");
            List<Disciplina> disciplinas = disciplinaRepository.findAll();
            disciplinas.forEach(System.out::println);

             Estudante estudante = new Estudante("Aluno A");
            estudante.setCurso(cursos.get(0));
            estudante.setDisciplinas(disciplinas);
             Estudante estudante2 = new Estudante("Aluno B");
            estudante2.setCurso(cursos.get(1));
            estudante2.setDisciplinas(disciplinas.stream().map(disciplina -> { if(disciplina.getDescricao().contains("Web")){return disciplina;} else {return null;}}).collect(Collectors.toList()));
            Estudante estudante3 = new Estudante("Aluno C");
            estudante3.setCurso(cursos.get(2));
            estudante3.setDisciplinas(disciplinas);

            estudanteRepository.save(estudante);
            estudanteRepository.save(estudante2);
            estudanteRepository.save(estudante3);
 
                        
            //FETCH LAZY OR EAGER?
            //List<Estudante> estudantes = estudanteRepository.findAll();
            List<Estudante> estudantes = estudanteRepository.findAllFetchDisciplinas();
           System.out.println("LISTANDO ESTUDANTES E DISCIPLINAS - FETCH");
            estudantes.forEach(
                e -> {
                    System.out.println(e.toString());
                    System.out.println(e.getDisciplinas().toString());
                }
                
            );
            
            
            List<Estudante> estudantePorDisciplina = estudanteRepository.findAllByDisciplinaId(disciplinas.get(1).getId());
            System.out.println("Lista Estudantes por Disciplina");
            estudantePorDisciplina.forEach(
                e -> {
                    System.out.println(e.toString());
                    //System.out.println(e.getDisciplinas().toString());
                    
                    
                }
                
            );

            
            Estudante estudanteDisciplinas = estudanteRepository.findById(2).map(e -> {return e;}).orElseThrow();
            List<Disciplina> disciplinasPorEstudante = disciplinaRepository.findAllByEstudanteId(estudanteDisciplinas.getId());
            System.out.println("Estudante");
            System.out.println(estudanteDisciplinas.toString());
            estudanteDisciplinas.setDisciplinas(disciplinasPorEstudante);
            System.out.println("Disciplinas");
            System.out.println(estudanteDisciplinas.getDisciplinas().toString());

            /* 

            List<Estudante> estudantesPorCurso = estudanteRepository.findAllByIdCurso(cursos.get(0).getId());
            estudantesPorCurso.forEach(System.out::println);
            List<Estudante> estudantesPorCurso2 = estudanteRepository.findAllByIdCurso(cursos.get(1).getId());
            estudantesPorCurso2.forEach(System.out::println);
            List<Estudante> estudantesPorCurso3 = estudanteRepository.findAllByIdCurso(cursos.get(2).getId());
            estudantesPorCurso3.forEach(System.out::println);

            Curso curso = cursoRepository.findById(2).map((c) -> {return c;}).orElseThrow();
            List<Estudante> estudantesPorCurso4 = estudanteRepository.findAllByIdCurso(curso.getId());
            curso.setEstudantes(new HashSet<>(estudantesPorCurso4));
            System.out.println("Estudantes do Curso: "+curso.getDescricao());
            curso.getEstudantes().forEach(System.out::println); */


            

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcAppDatajpaApplication.class, args);
	}

}
