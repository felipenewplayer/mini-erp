package com.example.erp.ERP.Pedido;

import com.example.erp.ERP.Cliente.Cliente;
import com.example.erp.ERP.Cliente.ClienteDto;
import com.example.erp.ERP.Cliente.ClienteRepository;
import com.example.erp.ERP.Config.TratadorDeErros;
import com.example.erp.ERP.ItemPedido.ItemPedidoDto;
import com.example.erp.ERP.Produto.ProdutoDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public List<PedidoDto> buscarListaPedidos() {
        List<Pedido> pedidos = repository.findAll();
        return pedidos.stream()
                .map(this::converterParaDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public Pedido buscarPedido(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido com o id " + id + " não encontrado"));
    }

    @Transactional
    public Pedido criarUmPedido(Pedido pedido) {
        Long clienteId = pedido.getCliente().getId();
        Cliente clienteSalvo = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new TratadorDeErros.RecursoNaoEncontradoException("Cliente com id " + clienteId + " não encontrado"));
        pedido.setCliente(clienteSalvo);

        // Ajusta a referência do pedido em cada item para evitar erros de persistência
        pedido.getItens().forEach(item -> item.setPedido(pedido));

        return repository.save(pedido);
    }

    @Transactional
    public void deletarUmPedido(Long id) {
        repository.deleteById(id);
    }

    private PedidoDto converterParaDto(Pedido pedido) {
        return new PedidoDto(
                pedido.getId(),
                new ClienteDto(
                        pedido.getCliente().getId(),
                        pedido.getCliente().getNome(),
                        pedido.getCliente().getEmail(),
                        pedido.getCliente().getTelefone()
                ),
                pedido.getData(),
                pedido.getItens().stream()
                        .map(item -> new ItemPedidoDto(
                                item.getId(),
                                new ProdutoDto(
                                        item.getProduto().getId(),
                                        item.getProduto().getNome(),
                                        item.getProduto().getPreco()
                                ),
                                item.getQuantidade(),
                                item.getPrecoUnitario(),
                                item.getSubTotal()
                        ))
                        .toList()
        );
    }
}
