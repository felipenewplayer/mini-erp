package com.example.erp.ERP.Produto;

import com.example.erp.ERP.Estoque.Estoque;
import com.example.erp.ERP.ItemPedido.ItemPedido;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produtos")
@JsonIgnoreProperties("produto")

@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private Double preco;

    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Estoque estoque;
}
