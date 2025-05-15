package com.example.erp.ERP.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente(1L, "Felipe", "felipe@gmail.com", "942170975");
    }

    @Test
    @DisplayName("Deve retornar uma lista de cliente")
    void deveRetornarListaDeClientes() {
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(cliente));
        List<Cliente> clientes = service.listaDeCliente();
        assertThat(clientes).hasSize(1);
    }
    @Test
    @DisplayName("Deve retorna vazio quando cliente não existe")
    void deveRetornarVazioQuandoClienteNaoExiste() {
        when(repository.findById(2L)).thenReturn(Optional.empty());
        Optional<Cliente> resultado = service.retornaUmCliente(2L);
        assertFalse(resultado.isPresent(), "Cliente não deveria ser encontrado.");
    }

    @Test
    @DisplayName("Deve criar um cliente com sucesso")
    void deveCriarUmClienteComSucesso() {
        when(repository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente resultado = service.criarCliente(cliente);
        assertThat(resultado).isEqualTo(cliente);
    }

    @Test
    @DisplayName("Deve retornar um cliente")
    void deveRetornarUmCliente(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(cliente));
        Optional<Cliente> resultado = service.retornaUmCliente(1L);
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNome()).isEqualTo("Felipe");
    }

    @Test
    @DisplayName("Deve deletar cliente")
    void deveDeletarCliente(){
        service.deletarCliente(1L);
        verify(repository,times(1)).deleteById(cliente.getId());
    }
}