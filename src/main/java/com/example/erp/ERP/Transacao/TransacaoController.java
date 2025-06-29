package com.example.erp.ERP.Transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private  final TransacaoService service;
    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao){
        Transacao transacaoNova = service.criaUmaTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoNova);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> retornaUmaTransacao(@PathVariable Long id){
        Transacao transacao = service.retornarUmTransacao(id);
        return ResponseEntity.ok(transacao);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTodas() {
        return ResponseEntity.ok(service.buscatListaDeTransacao());
    }

    @PutMapping
    public ResponseEntity<Transacao> buscaTransacaoAtualizada (@PathVariable Long id, @RequestBody Transacao transacaoAtualizada) {
        Transacao transacaoExistente = service.atualizaTransacao(id, transacaoAtualizada);
        return ResponseEntity.ok(transacaoExistente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTransacao(@PathVariable  Long id){
        service.deletarTransacao(id);
        return ResponseEntity.noContent().build();
    }
}
