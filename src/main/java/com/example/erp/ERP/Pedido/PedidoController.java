package com.example.erp.ERP.Pedido;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pedido> buscarListaDePedido(){
        return service.retornaListaDePedido();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscaUmPedido(@PathVariable  Long id){
        Optional<Pedido> pedido = service.retornarUmPedido(id);
        return pedido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pedido> criarUmPedido(@RequestBody Pedido pedido){
        service.criarUmPedido(pedido);
        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletearPedio(@PathVariable Long id){
        service.deletarUmPedido(id);
        return ResponseEntity.noContent().build();
    }
}
