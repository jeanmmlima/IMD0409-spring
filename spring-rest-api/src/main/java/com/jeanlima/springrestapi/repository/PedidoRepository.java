package com.jeanlima.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer>{

    List<Pedido> findByCliente(Cliente cliente);
    
}
