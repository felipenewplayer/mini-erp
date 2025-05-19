package com.example.erp.ERP.Cliente;

public record ClienteDto(
        Long id,
        String nome,
        String email,
        String telefone
) {}
