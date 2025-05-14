package com.example.erp.ERP.Integracao;

import com.example.erp.ERP.Cliente.Cliente;
import com.example.erp.ERP.Cliente.ClienteRepository;
import com.example.erp.ERP.Cliente.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
@ActiveProfiles("test") // Usa o application.yml
@DataJpaTest
public class ClienteRepositoryIT {

    @Autowired
    private ClienteRepository repository;

    @Test
    public void deveSalvarERecuperarCliente(){


        //Criar um cliente
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Felipe");
        cliente.setEmail("felipe@xurail.com");
        cliente.setTelefone("942170975");

        //Salva no banco
        Cliente salvo = repository.save(cliente);

        //Busca pelo ID
        Cliente encontrado = repository.findById(salvo.getId()).orElse(null);

        //Verificações
        assertThat(encontrado).isNotNull();
        assertThat(encontrado.getNome()).isEqualTo("Felipe");
        assertThat(encontrado.getId()).isEqualTo(1L);
        assertThat(encontrado.getEmail()).isEqualTo("felipe@xurail.com");
        assertThat(encontrado.getTelefone()).isEqualTo("942170975");
    }
}
