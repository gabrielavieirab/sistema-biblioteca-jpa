# Sistema de Biblioteca - API REST com Spring Boot e JPA

Este projeto foi desenvolvido como parte de uma avaliação de competências em Spring Boot, JPA e APIs REST.

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2.2**
- **Spring Data JPA**
- **MySQL Driver**
- **Springdoc OpenAPI (Swagger)**
- **Lombok**
- **Maven**

## 📂 Estrutura do Projeto
O projeto segue a arquitetura em camadas para melhor organização e manutenção:
- `model`: Entidades JPA com anotações de mapeamento e relacionamentos.
- `repository`: Interfaces que estendem JpaRepository para persistência de dados.
- `service`: Camada de lógica de negócio.
- `controller`: Endpoints REST para exposição da API.
- `config`: Configurações adicionais (ex: Swagger).

## 🛠️ Configuração do Banco de Dados
As configurações de conexão com o MySQL estão localizadas em `src/main/resources/application.properties`.
O sistema está configurado para criar o banco de dados automaticamente caso ele não exista (`createDatabaseIfNotExist=true`) e atualizar o esquema das tabelas (`ddl-auto=update`).

## 📖 Documentação da API (Swagger)
Após iniciar a aplicação, a documentação interativa dos endpoints pode ser acessada em:
`http://localhost:8080/swagger-ui.html`

## 📡 Endpoints Principais
- **Autores:** `/api/autores` (GET, POST, PUT, DELETE)
- **Editoras:** `/api/editoras` (GET, POST, PUT, DELETE)
- **Livros:** `/api/livros` (GET, POST, PUT, DELETE)

## ✅ Critérios Atendidos
1. **Configuração correta:** pom.xml e application.properties completos.
2. **Modelagem JPA:** Entidades com no mínimo 3 atributos, uso correto de anotações e relacionamentos (@ManyToOne, @OneToMany).
3. **API REST:** Métodos CRUD funcionais para todas as entidades seguindo boas práticas.
4. **Swagger:** Configuração e documentação funcional de todos os endpoints.
5. **Qualidade de Código:** Separação em camadas, código limpo e nomenclatura adequada.
