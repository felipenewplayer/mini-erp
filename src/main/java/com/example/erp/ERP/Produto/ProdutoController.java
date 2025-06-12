package com.example.erp.ERP.Produto;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    @Operation(summary = "Buscar um produto", description = "Retorna um produto referente ao seu id")
    @GetMapping("/{id}")
    public ResponseEntity<Produto>buscarUmProduto(@PathVariable Long id){
        Produto produto = service.buscarUmProduto(id);
        return ResponseEntity.ok(produto);
    }
    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista com todos os produtos cadastrados")
    @GetMapping
    public List<Produto> buscaListaDeProduto(){
        return service.retornaUmListaDeProduto();
    }

    @Operation(summary = "Criar um produto", description = "Retorna a criação de um produto")
    @PostMapping
    public ResponseEntity<Produto> criarUmProduto(@RequestBody @Valid Produto produto){

        Produto produtoNovo = service.criarUmProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoNovo);
    }

    @Operation(summary = "Atualizar um produto", description = "Retorna uma produto atualizado")
    @PutMapping("/{id}")
    public ResponseEntity<Produto>buscarProdutoAtualizado(@PathVariable  Long id, @RequestBody Produto produtoAtualizado){
        Produto produto = service.atualizarProduto(id, produtoAtualizado);
        return ResponseEntity.ok().body(produto);
    }

    @Operation(summary = "excluir um produto", description = "Retorna a exclusão de um produto")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUmProduto(@PathVariable Long id){
        service.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}

