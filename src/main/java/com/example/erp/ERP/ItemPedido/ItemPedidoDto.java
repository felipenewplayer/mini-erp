package com.example.erp.ERP.ItemPedido;

import com.example.erp.ERP.Produto.ProdutoDto;

public record ItemPedidoDto(Long id, ProdutoDto produto, Integer quantidade, Double precoUnitario, Double subTotal) {}
