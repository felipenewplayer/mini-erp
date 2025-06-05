package com.example.erp.ERP.Cliente;

import com.example.erp.ERP.Pedido.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String nome;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(length = 11, nullable = false, unique = true)
    private String telefone;

    @NotNull
    private String endereco;


   /* @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();*/

}
