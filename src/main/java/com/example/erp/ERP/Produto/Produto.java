    package com.example.erp.ERP.Produto;

    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.*;
    import lombok.Data;

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

        private Double precoUN;
        private  Integer quantidade;

        @Transient
        public Double getPrecoTotal() {
            if (quantidade != null && precoUN != null) {
                return quantidade * precoUN;
            }
            return 0.0;
        }
    }
