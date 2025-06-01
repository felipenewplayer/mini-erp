package com.example.erp.ERP.Transacao;

public enum Status {
    PAGO(1),
    PENDENTE(2),
    CANCELADO(3);

    private int code;

    Status(int code) {
        this.code = code;
    }
}
