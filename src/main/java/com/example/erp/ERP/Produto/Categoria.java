package com.example.erp.ERP.Produto;

public enum Categoria {
    CONSOLE(1),
    MONITOR(2),
    MOUSE(3),
    TECLADO(4),
    PROCESSADOR(5);

    private final int code;


    Categoria(int code) {
        this.code = code;
    }
}
