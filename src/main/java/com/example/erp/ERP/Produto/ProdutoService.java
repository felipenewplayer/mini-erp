package com.example.erp.ERP.Produto;

import com.example.erp.ERP.Config.TratadorDeErros;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto buscarUmProduto(Long id){
        return repository.findById(id).orElseThrow(()->
                new TratadorDeErros.RecursoNaoEncontradoException("Produto com id " + id + "não encontrado"));
    }

    public List<Produto> retornaUmListaDeProduto(){
       return repository.findAll();
    }

    public Produto criarUmProduto(Produto produto){
        return repository.save(produto);
    }

    public void deletarProduto(Long id){
        repository.deleteById(id);
    }
}
