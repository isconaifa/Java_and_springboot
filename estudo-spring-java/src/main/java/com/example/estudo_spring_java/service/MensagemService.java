package com.example.estudo_spring_java.service;

import org.springframework.stereotype.Service;

import com.example.estudo_spring_java.repository.MensagemRepository;

@Service
public class MensagemService {
    
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository){
        this.mensagemRepository = mensagemRepository;
    }

   public String obterMensagem(){
    return mensagemRepository.obterMensagem();
   }
}
