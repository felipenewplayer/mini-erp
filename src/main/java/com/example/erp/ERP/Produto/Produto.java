        package com.example.erp.ERP.Produto;

        import com.fasterxml.jackson.annotation.JsonFormat;
        import jakarta.persistence.*;
        import lombok.Data;
        import java.time.LocalDate;

        @Entity
        @Table(name = "produtos")
        @Data
        public class Produto {

                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;

                @Column(nullable = false)
                private String nome;

                @Column(name = "codigo_produto")
                private Integer codigoDoProduto;

                @Enumerated(EnumType.STRING)
                @Column(nullable = false)
                private Categoria categoria;

                private Integer quantidade;

                private Double precoUN;

                private Integer estoqueMinimo;
                private Integer estoqueMaximo;

                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                private LocalDate dataDeEntrada;

                @Transient
                public Double getPrecoTotal() {
                        if (quantidade != null && precoUN != null) {
                                return quantidade * precoUN;
                        }
                        return 0.0;
                }
        }

