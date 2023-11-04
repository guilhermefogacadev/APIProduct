
# API de Produtos (REST) com Spring Boot

Esta é uma API de produtos RESTful desenvolvida em Java com o framework Spring Boot e utiliza o banco de dados PostgreSQL para armazenar informações sobre produtos.
## Estudo
Estudo de Java Spring Boot 3 com o Mini Curso da Michelli Brito
https://www.youtube.com/watch?v=wlYvA2b1BWI 

## Requisitos

Certifique-se de ter as seguintes ferramentas e tecnologias instaladas antes de executar a aplicação:

- Java (Versão 17)
- Maven
- PostgreSQL
  
## Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL com o nome desejado.
2. Atualize as configurações do banco de dados no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
## Endpoints
A API oferece os seguintes endpoints:

-   `GET /api/produtos`: Recupera a lista de todos os produtos.
-   `GET /api/produtos/{id}`: Recupera um produto pelo ID.
-   `POST /api/produtos`: Cria um novo produto.
-   `PUT /api/produtos/{id}`: Atualiza os dados de um produto existente.
-   `DELETE /api/produtos/{id}`: Remove um produto pelo ID.
