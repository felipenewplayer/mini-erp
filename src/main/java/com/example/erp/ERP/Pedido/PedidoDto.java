package com.example.erp.ERP.Pedido;

import com.example.erp.ERP.Cliente.ClienteDto;
import com.example.erp.ERP.ItemPedido.ItemPedidoDto;

import java.time.LocalDate;
import java.util.List;

public record PedidoDto(Long id, ClienteDto cliente, LocalDate data, List<ItemPedidoDto> itens) {}
