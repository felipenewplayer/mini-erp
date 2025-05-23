package com.example.erp.ERP.Cliente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class
ClienteController {

    private final ClienteService service;
    public ClienteController(ClienteService service  ) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> retornarUmCliente(@PathVariable Long id) {
         Cliente cliente = service.buscarUmCliente(id);
         return ResponseEntity.ok(cliente);
    }
    @GetMapping
    public List<Cliente> retornarListaCliente(){
        return service.listaDeCliente();
    }

    @PostMapping
    public ResponseEntity<Cliente> criarClientes (@RequestBody Cliente cliente ){
        Cliente criandoCliente = service.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(criandoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
