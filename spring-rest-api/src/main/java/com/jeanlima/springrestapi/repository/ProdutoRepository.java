package com.jeanlima.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanlima.springrestapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
    
}
