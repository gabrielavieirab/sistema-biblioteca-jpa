# SISTEMA BIBLIOTECA - API REST

Este projeto é uma API para gerenciamento de biblioteca, desenvolvida como critério avaliativo para a disciplina de Desenvolvimento Web / Engenharia de Software.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2.2**
- **Spring Data JPA** (Persistência de dados)
- **MySQL 8.0** (Banco de dados)
- **Swagger/OpenAPI** (Documentação da API)
- **Maven** (Gerenciador de dependências)

## Estrutura do Projeto
O projeto segue o padrão de arquitetura em camadas:
- `model`: Entidades JPA com mapeamentos e relacionamentos.
- `repository`: Interfaces de persistência.
- `service`: Camada de lógica de negócio.
- `controller`: Endpoints REST da aplicação.

## Documentação (Swagger)
Após iniciar a aplicação, acesse a documentação interativa em:
`http://localhost:8081/swagger-ui.html`

## Endpoints Principais
- **Autores:** `/api/autores`
- **Editoras:** `/api/editoras`
- **Livros:** `/api/livros`

### **Responsável:** Gabriela Vieira Baptista 
