package com.jeanlima.springrestapi.service.impl;
import org.springframework.stereotype.Service;

import com.jeanlima.springrestapi.repository.PedidoRepository;
import com.jeanlima.springrestapi.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
    
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository repository) {
        this.pedidoRepository = repository;
    }
}
