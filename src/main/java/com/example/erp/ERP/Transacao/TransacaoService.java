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

    public Transacao criaUmaTransacao(Transacao transacao){
        return repository.save(transacao);
    }

    public Transacao retornarUmTransacao(Long id){
       return repository.findById(id).orElseThrow(()-> new TratadorDeErros.RecursoNaoEncontradoException("Transação com id " + id + " não encontrado"));
    }

    public List<Transacao> buscatListaDeTransacao(){
        return repository.findAll();
    }

    public  Transacao atualizaTransacao (Long id, Transacao transacaoAtualizada) {
        Transacao transacaoExistente = repository.findById(id).
                orElseThrow(() -> new TratadorDeErros.RecursoNaoEncontradoException("Transação com o id " + id + "não encontrado"));

        transacaoExistente.setValor(transacaoAtualizada.getValor());
        transacaoExistente.setTipo(transacaoAtualizada.getTipo());
        transacaoExistente.setVencimento(transacaoAtualizada.getVencimento());
        transacaoExistente.setDescricao(transacaoAtualizada.getDescricao());
        transacaoExistente.setStatus(transacaoAtualizada.getStatus());

        return repository.save(transacaoExistente);
    }


    public void deletarTransacao(Long id){
        repository.deleteById(id);
    }



}


