package com.example.erp.ERP.Estoque;

import com.example.erp.ERP.Produto.Produto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estoque")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidadeAtual;

    @OneToOne
    @JoinColumn(name = "produto_id", unique = true)
    @JsonBackReference
    private Produto produto;
}
