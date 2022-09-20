package com.jeanlima.mvcappdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeanlima.mvcappdatajpa.model.Estudante;


public interface EstudanteRepository extends JpaRepository<Estudante,Integer>{

    List<Estudante> findByNomeLike(String nome);
    List<Estudante> findByNomeOrId(String nome, Integer id);
    boolean existsByNome(String nome);

    /*
     * Trabalhando com @Query
     */
    //hql
    @Query(value = " select c from Estudante c where c.nome like %:nome% ")
    List<Estudante> encontrarPorNome(@Param("nome") String nome);

    //sql nativo
    @Query(value = " select * from estudante c where c.nome like %:nome% ",nativeQuery = true)
    List<Estudante> encontrarPorNomeMod(@Param("nome") String nome);

    @Query(value = " delete from Estudante c where c.nome =:nome")

    @Modifying //pois não é só consulta - transactional 
    void deletarPorNome(String nome);

    @Query(value = " select e.* from estudante e where e.curso_id = ?1",nativeQuery = true)
    List<Estudante> findAllByIdCurso(Integer id);

    @Query(value="SELECT DISTINCT e FROM Estudante e JOIN FETCH e.disciplinas")
    List<Estudante> findAllFetchDisciplinas();

    @Query(value="SELECT e FROM Estudante e JOIN e.disciplinas d where d.id =:id")
    List<Estudante> findAllByDisciplinaId(@Param("id") Integer id);

}
