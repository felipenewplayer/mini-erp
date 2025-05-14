package com.example.erp.ERP.Produto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto>buscarUmProduto(@PathVariable Long id){
        Optional<Produto> produto = service.buscarUmProduto(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Produto> buscaListaDeProduto(){
        return service.retornaUmListaDeProduto();
    }

    @PostMapping
    public Produto criarUmProduto(@RequestBody Produto produto){
        return service.criarUmProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUmProduto(@PathVariable Long id){
        service.deletarProduto(id);
        return ResponseEntity.notFound().build();
    }
}

