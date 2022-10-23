package com.jeanlima.springrestapi.service;

import java.math.BigDecimal;

import com.jeanlima.springrestapi.model.Produto;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoDescricaoProdutoDTO;

public interface ProdutoService {
    Produto salvar( AtualizacaoDescricaoProdutoDTO dto );
    void atualizaDescricao(Integer id, String descricao, BigDecimal preco);
    
}
