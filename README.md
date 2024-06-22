# API de Funcionários

Este projeto é uma aplicação Spring Boot para Assessment que fornece uma API com as seguintes
entidades: `Usuario`, `Funcionario` e `Departamentos`.

## Entidades

- **Usuario**: Representa um usuário com funções de autenticação e autorização.
- **Funcionario**: Representa um funcionário. Cada `Funcionario` pode pertencer a vários `Departamentos`.
- **Departamentos**: Representa um departamento dentro da organização.

## Funcionalidades

- **Spring Security**: Utilizado para proteger os endpoints da API com autenticação básica.
- **Spring Data JPA**: Utilizado para ORM e interação com o banco de dados.
- **Banco de Dados H2**: Um banco de dados em memória utilizado para desenvolvimento e testes.
- **Docker**: Utilizado para containerizar a aplicação, garantindo um ambiente consistente e fácil de implantar.

## Endpoints da API

### Usuario

- **POST /usuarios/cadastra**: Cria um novo usuário.
- **GET /usuarios/encontrar-por**: Encontra um usuário pelo nome.

### Funcionario

- **POST /funcionarios**: Salva um novo funcionário.
- **GET /funcionarios/{id}**: Obtém detalhes de um funcionário pelo ID.
- **PUT /funcionarios/{id}**: Atualiza os detalhes de um funcionário.
- **DELETE /funcionarios/{id}**: Exclui um funcionário.

### Departamentos

- **POST /departamentos**: Cria um novo departamento.
- **GET /departamentos/{id}**: Obtém detalhes de um departamento pelo ID.
- **PUT /departamentos/{id}**: Atualiza os detalhes de um departamento.
- **DELETE /departamentos/{id}**: Exclui um departamento.

## Bibliotecas Utilizadas

- **Spring Security**: Para segurança da aplicação.
- **Spring Data JPA**: Para ORM e acesso a dados.
- **Banco de Dados H2**: Para banco de dados em memória.
- **Docker**: Para containerização da aplicação.

## Testes

- **SpringBootTest**: Utilizado para testes de integração.
- **MockMvc**: Utilizado para testar slices da aplicação, permitindo simular chamadas HTTP e verificar respostas.

## Executando a Aplicação

### Usando Docker

1. Certifique-se de que o Docker está instalado e em execução.
2. Construa a imagem Docker:
    ```sh
    docker build -t my-spring-boot-app .
    ```
3. Execute o container Docker:
    ```sh
    docker run -p 8080:8080 my-spring-boot-app
    ```

A aplicação estará acessível em `http://localhost:8080`.

### Executando Localmente

1. Certifique-se de ter o JDK 11 ou posterior instalado.
2. Clone o repositório e navegue até o diretório do projeto.
3. Execute a aplicação:
    ```sh
    ./mvnw spring-boot:run
    ```

A aplicação será iniciada em `http://localhost:8080`.

## Licença

Este projeto está licenciado sob a Licença MIT.
