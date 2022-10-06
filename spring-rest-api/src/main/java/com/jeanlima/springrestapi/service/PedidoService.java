package com.jeanlima.springrestapi.service;

import com.jeanlima.springrestapi.model.Pedido;
import com.jeanlima.springrestapi.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
}
