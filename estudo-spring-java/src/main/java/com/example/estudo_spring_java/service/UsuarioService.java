package com.example.estudo_spring_java.service;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.estudo_spring_java.EstudoSpringJavaApplication;
import com.example.estudo_spring_java.model.Usuario;
import com.example.estudo_spring_java.repository.UsuarioRepository;

@Service
public class UsuarioService {



    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, EstudoSpringJavaApplication estudoSpringJavaApplication) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registrarUsuario(String username, String password){
       String senhaCriptografada = passwordEncoder.encode(password);
       Usuario usuario = new Usuario(username, senhaCriptografada);
       return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
}
