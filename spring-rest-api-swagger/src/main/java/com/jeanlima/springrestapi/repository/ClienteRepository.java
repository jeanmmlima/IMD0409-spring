package com.jeanlima.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeanlima.springrestapi.model.Cliente;

//classe e tipo do id
//start jpa já escaneia interfaces que herdam o JpaRepository - não precisa da anotaçao
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

    /*
     * Já tem um entity manager encapsulado que vai fazer as operações de transação!
     */

    /*
     * implementando um Query Method - que será executado com o entitymanager encapsulado
     */

    //selec c from Cliente c where c.nome like :nome
    List<Cliente> findByNomeLike(String nome);
    List<Cliente> findByNomeOrId(String nome, Integer id);
    boolean existsByNome(String nome);

    /*
     * Trabalhando com @Query
     */
    //hql
    @Query(value = " select c from Cliente c where c.nome like %:nome% ")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    //sql nativo
    @Query(value = " select * from cliente c where c.nome like %:nome% ",nativeQuery = true)
    List<Cliente> encontrarPorNomeMod(@Param("nome") String nome);

    @Query(value = " delete from Cliente c where c.nome =:nome")
    @Modifying //pois não é só consulta - transactional 
    void deletarPorNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id  ")
    Cliente findClienteFetchPedidos( @Param("id") Integer id );

    
    
}
