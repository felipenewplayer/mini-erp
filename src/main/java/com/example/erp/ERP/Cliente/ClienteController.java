package com.example.erp.ERP.Cliente;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class
ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente>buscarUmCliente(@PathVariable Long id){
        Optional<Cliente> cliente = service.retornaUmCliente(id);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());

    }
    @GetMapping
    public List<Cliente> retornarListaCliente(){
        return service.listaDeCliente();
    }

    @PostMapping
    public ResponseEntity<Cliente> criarClientes(@RequestBody Cliente cliente ){
        Cliente criandoCliente = service.criarCliente(cliente);
        return ResponseEntity.ok(criandoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
