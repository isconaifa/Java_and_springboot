package com.example.estudo_spring_java.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {
    
    public String obterMensagem(){
        return "Obter Mensagem do repository";
    }
}
