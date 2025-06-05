package com.example.erp.ERP.Cliente;

import com.example.erp.ERP.Config.TratadorDeErros;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;}

    public Cliente criarCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente buscarUmCliente(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new TratadorDeErros.RecursoNaoEncontradoException("Cliente com id " + id + " não encontrado"));
    }

    public List<Cliente> listaDeCliente(){
        return repository.findAll();
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado){
        Cliente clienteExistente = repository.findById(id)
                .orElseThrow(()-> new TratadorDeErros.RecursoNaoEncontradoException("Cliente com id" + id + "não encontrado"));

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());

        return repository.save(clienteExistente);
    }


    public void deletarCliente(Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow(()-> new TratadorDeErros.RecursoNaoEncontradoException("Cliente com  " + id + " não encontrado"));
        repository.delete(cliente);
    }
}
