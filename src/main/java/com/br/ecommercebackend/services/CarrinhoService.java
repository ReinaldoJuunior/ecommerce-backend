package com.br.ecommercebackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ecommercebackend.entities.ItemCarrinho;
import com.br.ecommercebackend.repository.ItemCarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private ItemCarrinhoRepository carrinhoRepository;
	
	public List<ItemCarrinho> getItensCarrinho(){
		return carrinhoRepository.findAll();
	}
	
	public ItemCarrinho addItemPedido(ItemCarrinho itemCarrinho) {
		return carrinhoRepository.save(itemCarrinho);
	}
	
	public void removeItemCarrinho(Long id) {
		carrinhoRepository.deleteById(id);
	}

}
