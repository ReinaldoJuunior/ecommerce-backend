package com.br.ecommercebackend.controllers;


import com.br.ecommercebackend.entities.ItemCarrinho;
import com.br.ecommercebackend.services.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public List<ItemCarrinho> getItensCarrinho(){
        return carrinhoService.getItensCarrinho();
    }

    @PostMapping
    public ItemCarrinho addItemCarrinho(@RequestBody ItemCarrinho itemCarrinho){
        return carrinhoService.addItemPedido(itemCarrinho);
    }

    @DeleteMapping
    public void deletarItem(@PathVariable Long id){
        carrinhoService.removeItemCarrinho(id);
    }
}
