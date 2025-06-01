/*
package com.example.erp.ERP.Estoque;

import com.example.erp.ERP.Pedido.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueListener {

    private static final Logger logger = LoggerFactory.getLogger(EstoqueListener.class);
    private final EstoqueService estoqueService;

    public EstoqueListener(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @RabbitListener(queues = "pedido.fila")
    public void consumirPedido(Pedido pedido) {
        try {
            if (pedido != null && pedido.getItens() != null) {
                logger.info("📦 Pedido recebido em {} com {} item(ns)",
                        pedido.getData(),
                        pedido.getItens().size()
                );
                estoqueService.atualizarPedido(pedido);
                // Aqui você pode iniciar o controle de estoque, por exemplo:
                // estoqueService.atualizarEstoque(pedido);
            } else {
                logger.warn("⚠️ Pedido recebido está vazio ou incompleto");
            }
        } catch (Exception e) {
            logger.error("❌ Erro ao processar pedido: {}", e.getMessage(), e);
        }
    }
}
*/
