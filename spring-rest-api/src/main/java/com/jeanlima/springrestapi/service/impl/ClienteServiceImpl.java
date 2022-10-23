package com.jeanlima.springrestapi.service.impl;

import org.springframework.stereotype.Service;

import com.jeanlima.springrestapi.exception.RegraNegocioException;
import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.repository.ClienteRepository;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoNomeClienteDTO;
import com.jeanlima.springrestapi.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clientesRepository;
    
    @Override
    public Cliente salvar(AtualizacaoNomeClienteDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void atualizaNome(Integer id, String nome) {
        clientesRepository
            .findById(id)
            .map( cliente -> {
                cliente.setNome(nome);
                return clientesRepository.save(cliente);
            }).orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));
    }
}