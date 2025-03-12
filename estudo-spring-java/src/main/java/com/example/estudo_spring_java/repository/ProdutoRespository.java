package com.example.estudo_spring_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estudo_spring_java.model.Produto;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Long> {

    
}
