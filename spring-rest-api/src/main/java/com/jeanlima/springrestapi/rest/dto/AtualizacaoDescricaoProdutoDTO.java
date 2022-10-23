package com.jeanlima.springrestapi.rest.dto;


import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProdutoDTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AtualizacaoDescricaoProdutoDTO {
    private String descricao;
    private BigDecimal preco;
}
