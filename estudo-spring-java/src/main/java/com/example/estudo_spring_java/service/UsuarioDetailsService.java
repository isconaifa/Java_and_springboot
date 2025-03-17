package com.example.estudo_spring_java.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.estudo_spring_java.model.Usuario;
import com.example.estudo_spring_java.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {


    private final UsuarioRepository usuarioRepository;
    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  
         Usuario usuario = usuarioRepository.findByUsername(username)
         .orElseThrow(()-> new UsernameNotFoundException ("Usuário não encontrado"));

         return User.builder()
         .username(usuario.getUsername())
         .password(usuario.getPassword())
         .roles("USER")
         .build();
       

         
         

    }
    
}
