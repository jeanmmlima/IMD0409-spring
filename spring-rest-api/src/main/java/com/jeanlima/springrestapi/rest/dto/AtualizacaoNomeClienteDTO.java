package com.jeanlima.springrestapi.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClienteDTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AtualizacaoNomeClienteDTO {
    private String nome;
}