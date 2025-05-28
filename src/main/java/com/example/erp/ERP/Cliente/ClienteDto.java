package com.example.erp.ERP.Cliente;

import jakarta.validation.constraints.*;

public record ClienteDto(

        @NotNull Long id,
        @Size(max = 12, min = 5) @NotNull String nome,
        @Email @NotBlank String email,
        @Pattern(regexp = "\\d{10,11}", message = "Número de telefone deve ter 10 ou 11 dígitos")
        String telefone
) {}
