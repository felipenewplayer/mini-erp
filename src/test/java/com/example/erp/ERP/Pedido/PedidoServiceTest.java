/*
package com.example.erp.ERP.Pedido;

import com.example.erp.ERP.Cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;
    @InjectMocks
    private PedidoService service;
    private PedidoDto pedidoDto;
    private Pedido pedido;
    private Cliente cliente;
    LocalDate dataFixa = LocalDate.of(2025, 10, 5);


    @BeforeEach
    void setUp(){
        cliente = Cliente.builder().id(1L).build();

        pedido = Pedido.builder()
                .id(1L)
                .cliente(cliente)
                .data(dataFixa)
                .itens(new ArrayList<>())
                .build();
    }



    @Test
    @DisplayName("Deve retornar um pedido")
    void deveRetornarUmPedido(){
        //arrange
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(pedido));
        //act
        Pedido resultado = service.buscarPedido(1L);
        //assert


        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getData()).isEqualTo(dataFixa);
    }

    @Test
    @DisplayName("Deve retornar lista de pedidos")
    void deveRetornarListaDePedido(){
        List<Pedido> pedidos = List.of(pedido);
        Mockito.when(repository.findAll()).thenReturn(pedidos);

        List<PedidoDto> resultado = service.buscarListaPedidos();

        assertThat(resultado).isNotNull();
        assertThat(resultado).hasSize(1);
        assertThat(resultado.get(0).id()).isEqualTo(1L);
        assertThat(resultado.get(0).data()).isEqualTo(dataFixa);

    }

    @Test
    @DisplayName("Deve cria um pedido")
    void deveCriarUmPedido(){
        Mockito.when(repository.save(pedido)).thenReturn(pedido);
        Pedido resultado = service.criarUmPedido(pedido);
        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1L);
        Mockito.verify(repository).save(pedido);
    }

    @Test
    @DisplayName("Deve deletar um pedido")
    void deveDeletarUmPedido(){
        service.deletarUmPedido(1L);
        Mockito.verify(repository).deleteById(1L);
    }
}*/
