package com.jeanlima.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanlima.springrestapi.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Integer>{
    
}
