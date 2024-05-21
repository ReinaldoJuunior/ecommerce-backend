package com.br.ecommercebackend.controllers;

import com.br.ecommercebackend.entities.ItemCarrinho;
import com.br.ecommercebackend.entities.Pedido;
import com.br.ecommercebackend.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido encomendaPedidos(@RequestBody List<ItemCarrinho> itensCarrinho) throws Exception {
        return pedidoService.encomendaPedido(itensCarrinho);
    }

}
