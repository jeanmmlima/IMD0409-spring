package com.jeanlima.springrestapi.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.jeanlima.springrestapi.exception.RegraNegocioException;
import com.jeanlima.springrestapi.model.Produto;
import com.jeanlima.springrestapi.repository.ProdutoRepository;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoDescricaoProdutoDTO;
import com.jeanlima.springrestapi.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{
    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(AtualizacaoDescricaoProdutoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void atualizaDescricao(Integer id, String descricao, BigDecimal preco) {
        produtoRepository
            .findById(id)
            .map( produto -> {
                produto.setDescricao(descricao);
                produto.setPreco(preco);
                return produtoRepository.save(produto);
            }).orElseThrow(() -> new RegraNegocioException("Código de produto inválido."));
    }
}
