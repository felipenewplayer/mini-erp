package com.example.erp.ERP.ItemPedido;

import com.example.erp.ERP.Pedido.Pedido;
import com.example.erp.ERP.Produto.Produto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private Integer quantidade;
    private Double precoUnitario;

    public Double getSubTotal() {
        return quantidade * precoUnitario;
    }
}