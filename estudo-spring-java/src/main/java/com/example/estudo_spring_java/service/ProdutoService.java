package com.example.estudo_spring_java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.estudo_spring_java.exceptions.RecursoNaoEncontradoException;
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

    public Produto buscarProdutoId(Long id) {
        return produtoRespository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " +id+" não encontrado"));
    }

    public Produto SalvarProduto(Produto produto) {
        return produtoRespository.save(produto);
    }

    public void deletarProduto(Long id) {
        if (!produtoRespository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto com ID " +id+ " não encontrado.");
        }
        produtoRespository.deleteById(id);
    }
}
