package com.example.demo.service;

import com.example.demo.repository.PedidoRepository;
import com.example.demo.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository=pedidoRepository;
    }

    public Pedido criarPedido(Pedido pedido){
        validarPedido(pedido); //esse é o dto
        return pedidoRepository.save(pedido);
    }

    private void validarPedido(Pedido pedido){
        if(pedido == null){
            throw new IllegalArgumentException("Pedido Vazio!");
        }
        if (pedido.getQuantidade() <=0) {
            throw new QuantidadeInvalidaException("Quantidade invalida, menosr ou igual a zero.");
        }
        if(pedido.getPrecoTotal().compareTo(BigDecimal.ZERO) <=0) {
            throw new PrecoInvalidoException("preco nao pode ser zero");
        }
    }

}
