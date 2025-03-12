package com.example.estudo_spring_java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.estudo_spring_java.model.Produto;
import com.example.estudo_spring_java.repository.ProdutoRespository;

@Service
public class ProdutoService {

    private final ProdutoRespository produtoRespository;

    public ProdutoService(ProdutoRespository produtoRespository) {
        this.produtoRespository = produtoRespository;
    }

    public List<Produto> listarProduto() {
        return produtoRespository.findAll();
    }

    public Optional<Produto> buscarProdutoId(Long id) {
        return produtoRespository.findById(id);
    }

    public Produto SalvarProduto(Produto produto) {
        return produtoRespository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRespository.deleteById(id);
    }
}
