package com.jeanlima.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/segundo")
public class MeuSegundoController {

    @GetMapping("/hello")
    public String hello() {
        return "Olá, mundo do Spring! Saudação do segundo controller!";

    }
}