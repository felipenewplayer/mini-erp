/*
package com.example.erp.ERP.Pedido;

import com.example.erp.ERP.Cliente.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoProducer producer;
    private final PedidoService service;
    private final ClienteService clienteService;

    public PedidoController(PedidoProducer producer, PedidoService service, ClienteService clienteService) {
        this.producer = producer;
        this.service = service;
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> retornaBuscarPedido(@PathVariable  Long id){
        Pedido pedido = service.buscarPedido(id);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDto>> retornaABuscarListaDePedido(){
        List<PedidoDto> pedidos = service.buscarListaPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping()
    public ResponseEntity<Pedido> criarPedido(@RequestBody @Valid Pedido pedido) {
        Pedido novoPedido = service.criarUmPedido(pedido);
        producer.enviarPedido(novoPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> retornarDeletarPedido(@PathVariable Long id){
        service.deletarUmPedido(id);
        return ResponseEntity.noContent().build();
    }
}
*/
