package com.example.erp.ERP.Cliente;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

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
    public ResponseEntity<Cliente> criarClientes (@RequestBody @Valid Cliente cliente ){
        Cliente criandoCliente = service.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(criandoCliente);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> retornaClienteAtualizado(@PathVariable Long id, @RequestBody Cliente clienteAtualizado){
        Cliente clienteExistente = service.atualizarCliente(id, clienteAtualizado);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteExistente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
