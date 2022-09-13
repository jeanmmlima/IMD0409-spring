package com.jeanlima.mvcappdatajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jeanlima.mvcappdatajpa.model.Estudante;
import com.jeanlima.mvcappdatajpa.repository.EstudanteRepository;

@SpringBootApplication
public class MvcAppDatajpaApplication {

	/* @Autowired 
	EstudanteRepository estudanteRepository; */

	/* @Bean
	public CommandLineRunner init(){
		return args -> {
			System.out.println("Salvando estudantes");
            estudanteRepository.salvar(new Estudante("José Maria", "BTI"));
            estudanteRepository.salvar(new Estudante("Maria da Glória", "Eng Software"));

            List<Estudante> todosEstudantes = estudanteRepository.obterTodos();
            todosEstudantes.forEach(System.out::println);

            System.out.println("Atualizando estudantes");
            todosEstudantes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                estudanteRepository.atualizar(c);
            });

            todosEstudantes = estudanteRepository.obterTodos();
            todosEstudantes.forEach(System.out::println);

            System.out.println("Buscando estudantes");
            estudanteRepository.buscarPorNome("J").forEach(System.out::println);

            System.out.println("deletando estudantes");
            estudanteRepository.obterTodos().forEach(c -> {
                estudanteRepository.deletar(c);
            });

            todosEstudantes = estudanteRepository.obterTodos();
            if(todosEstudantes.isEmpty()){
                System.out.println("Nenhum estudante encontrado.");
            }else{
                todosEstudantes.forEach(System.out::println);
            }
		};
	} */

	public static void main(String[] args) {
		SpringApplication.run(MvcAppDatajpaApplication.class, args);
	}

}
