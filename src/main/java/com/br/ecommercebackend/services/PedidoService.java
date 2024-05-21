package com.br.ecommercebackend.services;

import com.br.ecommercebackend.entities.ItemCarrinho;
import com.br.ecommercebackend.entities.ItemPedido;
import com.br.ecommercebackend.entities.Pedido;
import com.br.ecommercebackend.entities.Produto;
import com.br.ecommercebackend.repository.PedidoRepository;
import com.br.ecommercebackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido encomendaPedido(List<ItemCarrinho> itensCarrinho) throws Exception {
        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());

        BigDecimal totalPedido = BigDecimal.ZERO;
        List<ItemPedido> itensPedido = new ArrayList<>();

        for(ItemCarrinho itemCarrinho : itensCarrinho){
            Produto produto = produtoRepository.findById(itemCarrinho.getProdutcId()).orElseThrow(()-> new Exception("Produto não encontrado"));
            if(produto.getQuantidadeEstoque() < itemCarrinho.getQuantidade()){
                throw new Exception("Estoque insuficiente para o produto:" + produto.getNome());
            }
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - itemCarrinho.getQuantidade());
            produtoRepository.save(produto);

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProdutoId(produto.getId());
            itemPedido.setQuantidade(itemCarrinho.getQuantidade());
            itemPedido.setPreco(produto.getPrice().multiply(BigDecimal.valueOf(itemCarrinho.getQuantidade())));
            itensPedido.add(itemPedido);

            totalPedido = totalPedido.add(itemPedido.getPreco());

        }
        pedido.setItems(itensPedido);
        pedido.setValorTotal(totalPedido);

        return pedidoRepository.save(pedido);
    }

}
