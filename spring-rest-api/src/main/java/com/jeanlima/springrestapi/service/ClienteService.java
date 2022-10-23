package com.jeanlima.springrestapi.service;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoNomeClienteDTO;

public interface ClienteService {
    Cliente salvar( AtualizacaoNomeClienteDTO dto );
    void atualizaNome(Integer id, String nome);
}