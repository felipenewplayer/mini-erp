package com.example.erp.ERP.Transacao;

import com.example.erp.ERP.Config.TratadorDeErros;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Transacao retornarUmTransacao(Long id){
       return repository.findById(id).orElseThrow(()-> new TratadorDeErros.RecursoNaoEncontradoException("Transação com id " + id + " não encontrado"));
    }

    public List<Transacao> buscatListaDeTransacao(){
        return repository.findAll();
    }

    public Transacao criaUmaTransacao(Transacao transacao){
        Transacao novaTransacao = repository.save(transacao);
        return novaTransacao;
    }

    public void deletarTransacao(Long id){
        repository.deleteById(id);
    }



}


