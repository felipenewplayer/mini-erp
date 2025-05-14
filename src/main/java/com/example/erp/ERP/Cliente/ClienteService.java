package com.example.erp.ERP.Cliente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Optional<Cliente> retornaUmCliente(Long id){
        return repository.findById(id);
    }
    public List<Cliente> listaDeCliente(){
        return repository.findAll();
    }

    public Cliente criarCliente(Cliente cliente){
       return repository.save(cliente);
    }

    public void deletarCliente(Long id){
        repository.deleteById(id);
    }
}
