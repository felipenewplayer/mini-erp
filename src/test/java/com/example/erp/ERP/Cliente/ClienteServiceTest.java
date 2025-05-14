package com.example.erp.ERP.Cliente;

import org.junit.jupiter.api.Assertions;
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
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {


    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteService service;

    @Test
    @DisplayName("Deve retornar uma lista de cliente")
    public void deveRetornaUmListaCliente() {
        Cliente cliente = new Cliente(1l,  "Felipe", "felipeaperei2014@gmail.com","942170975");
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(cliente));
        List<Cliente> clientes = service.listaDeCliente();

        Assertions.assertEquals(1, clientes.size());

    }
    @Test
    void retornaClienteNaoEncontrado() {
        // Simula um cliente não encontrado
        when(repository.findById(2L)).thenReturn(Optional.empty());

        Optional<Cliente> resultado = service.retornaUmCliente(2L);

        assertFalse(resultado.isPresent(), "Cliente não deveria ser encontrado.");
    }

    @Test
    @DisplayName("Deve criar um cliente com sucesso")
    void criarUmCliente() {

        // Arrange: cria o cliente de entrada (sem ID)
        Cliente clienteParaSalvar = new Cliente();
        clienteParaSalvar.setNome("Felipe");
        clienteParaSalvar.setEmail("felipe@gmail.com");
        clienteParaSalvar.setTelefone("942170975");

        // Simula o retorno com ID, como se tivesse sido salvo no banco
        Cliente clienteSalvo = new Cliente(
                1L,
                "Felipe",
                "felipe@gmail.com",
                "942170975");

        // Configura o mock do repository
        when(repository.save(any(Cliente.class))).thenReturn(clienteSalvo);

        // Act: chama o serviço
        Cliente resultado = service.criarCliente(clienteParaSalvar);

        // Assert: validações
        assertThat(resultado).isNotNull();
        assertThat(resultado.getId()).isEqualTo(1L);
        assertThat(resultado.getNome()).isEqualTo("Felipe");
        assertThat(resultado.getEmail()).isEqualTo("felipe@gmail.com");
        assertThat(resultado.getTelefone()).isEqualTo("942170975");
    }
}