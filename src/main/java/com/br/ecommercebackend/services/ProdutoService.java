package com.br.ecommercebackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ecommercebackend.entities.Produto;
import com.br.ecommercebackend.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}

	public Produto findById(Long id) throws Exception {
		return produtoRepository.findById(id).orElseThrow (() -> new Exception("Produto não encontrado"));
	}
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
}
