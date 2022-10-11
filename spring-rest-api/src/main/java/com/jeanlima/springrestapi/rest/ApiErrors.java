package com.jeanlima.springrestapi.rest;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;
    //lista de erros
    public ApiErrors(String mensagemErro){
        this.errors = Arrays.asList(mensagemErro);
    }
}
