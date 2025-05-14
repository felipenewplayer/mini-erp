package com.example.erp.ERP.Pedido;

import com.example.erp.ERP.Cliente.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Optional<Pedido> retornarUmPedido(Long id) {
        return repository.findById(id);
    }

    public List<Pedido> retornaListaDePedido(){
        return repository.findAll();
    }

    public Pedido criarUmPedido(Pedido pedido){
        return repository.save(pedido);
    }

    public void deletarUmPedido(Long id){
        repository.deleteById(id);
    }
}
