package com.br.ecommercebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ecommercebackend.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
