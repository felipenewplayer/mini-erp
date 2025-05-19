//package com.example.erp.ERP.Pedido;
//
//import com.example.erp.ERP.Cliente.Cliente;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class PedidoMapper {
//
//    public PedidoDto toDto(Pedido pedido){
//        return new PedidoDto(
//                pedido.getId(),
//                pedido.getCliente().getId(),
//                pedido.getData()
//        );
//    }
//
//    public Pedido toEntity(PedidoDto pedidoDto, Optional<Cliente> cliente){
//        return Pedido.builder()
//                .id(pedidoDto.id())
//                .cliente(cliente)
//                .data(pedidoDto.data())
//                .build();
//    }
//}
