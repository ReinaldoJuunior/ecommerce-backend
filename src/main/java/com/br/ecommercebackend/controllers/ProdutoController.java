package com.br.ecommercebackend.controllers;

import com.br.ecommercebackend.entities.Produto;
import com.br.ecommercebackend.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos(){
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public List<Produto> getIdProduto(@PathVariable Long id) throws Exception {
        return (List<Produto>) produtoService.findById(id);
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto){
        produto.setId(id);
        return produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.delete(id);
    }

}
