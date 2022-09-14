package com.jeanlima.mvcappdatajpa;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jeanlima.mvcappdatajpa.model.Curso;
import com.jeanlima.mvcappdatajpa.model.Estudante;
import com.jeanlima.mvcappdatajpa.repository.CursoRepository;
import com.jeanlima.mvcappdatajpa.repository.EstudanteRepository;

@SpringBootApplication
public class MvcAppDatajpaApplication {

	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	EstudanteRepository estudanteRepository;

	@Bean
	public CommandLineRunner init(){
		return args -> {
			System.out.println("Cadastrando cursos");

			cursoRepository.save(new Curso("BTI"));
            cursoRepository.save(new Curso("Engenharia de Computação"));
            cursoRepository.save(new Curso("Engenharia de Software"));
            cursoRepository.save(new Curso("Ciência da Computação"));

            System.out.println("Cursos cadastrados");
            List<Curso> cursos = cursoRepository.findAll();
            cursos.forEach(System.out::println);

            Estudante estudante = new Estudante("João");
            estudante.setCurso(cursos.get(0));
            Estudante estudante2 = new Estudante("Maria");
            estudante2.setCurso(cursos.get(1));
            Estudante estudante3 = new Estudante("Jose");
            estudante3.setCurso(cursos.get(2));

            estudanteRepository.save(estudante);
            estudanteRepository.save(estudante2);
            estudanteRepository.save(estudante3);

            List<Estudante> estudantes = estudanteRepository.findAll();
            estudantes.forEach(System.out::println);

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
            curso.getEstudantes().forEach(System.out::println);


            

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcAppDatajpaApplication.class, args);
	}

}
