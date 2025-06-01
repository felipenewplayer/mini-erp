package com.example.erp.ERP.Transacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private  final TransacaoService service;
    public TransacaoController(TransacaoService service) {
        this.service = service;
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
}
