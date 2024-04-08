package com.example.demo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue
    private Long id;

    private Integer quantidade;
    private BigDecimal precoTotal;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // configurando o cascade para que toda operacao feita em pedido altere todos os itens de pedido
    private List<ItemPedido> listaPedidos; // LAZY = carregar sem ser tudo de uma vez, otimizar aplicação
    // quando fazemos pesquisa no banco de dados, ele devolve uma lista de pedidos
    // para mostrar apenas os itens necessários, economizando memoria computacional
    // nesse exemplo nao usamos mapped by pq
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<ItemPedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<ItemPedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
}
