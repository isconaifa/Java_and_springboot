package com.example.estudo_spring_java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.estudo_spring_java.service.MensagemService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping
public class MensagemController {
    private final MensagemService mensagemService;


    public  MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public String mensagem() {
        return mensagemService.obterMensagem();
    }
    
    
}
