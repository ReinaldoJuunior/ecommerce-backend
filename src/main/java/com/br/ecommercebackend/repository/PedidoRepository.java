package com.br.ecommercebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.ecommercebackend.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
