# Mini-ERP - Sistema de Gestão Empresarial
O Mini-ERP é um sistema de gestão empresarial desenvolvido em Java com Spring Boot para gerenciamento de produtos, pedidos e clientes. Ele foi projetado para pequenas e médias empresas que necessitam de uma solução simples e eficaz para controle de vendas e estoque.

| Módulo       | Responsabilidade Principal                   |
| ------------ | -------------------------------------------- |
| `cliente`    | Cadastro, consulta e atualização de clientes |
| `produto`    | Controle de produtos e estoque               |
| `pedido`     | Registro de pedidos, carrinho, finalização   |
| `pagamento`  | (futuro) Integração com métodos de pagamento |
| `entrega`    | (futuro) Rastreamento e status de entrega    |
| `relatorios` | (futuro) Geração de relatórios gerenciais    |
| `usuarios`   | (futuro) Controle de usuários e autenticação |

<br></br>
| Camada         | Tecnologia                    |
| -------------- | ----------------------------- |
| Backend        | Spring Boot 3.4.5 + Java 21   |
| Banco de Dados | MySQL (via Docker Compose)    |
| Build Tool     | Maven                         |
| Deploy         | Docker/Docker Compose         |
| API Doc        | Swagger (SpringDoc)           |
| Segurança      | Spring Security (futuro)      |
| Logs           | Spring Boot Actuator (futuro) |

<br></br>
⚙️ Fluxo de Execução Típico

Frontend envia requisição REST para o backend.

Backend valida, aplica regras de negócio (serviço).

Serviço interage com o repositório (JPA).

Resposta é retornada ao cliente.

<br></br>
🧪 Testes (futuro)
JUnit + Mockito para testes unitários

Testcontainers para testes de integração com banco

