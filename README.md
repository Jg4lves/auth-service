# 🔐 Auth Service

Serviço de autenticação desenvolvido com Spring Boot, utilizando JWT para controle de acesso.

## Funcionalidades

- Cadastro de usuário
- Login com geração de token JWT
- Exclusão de usuário autenticado
- Autenticação via filtro JWT
- Armazenamento em memória (UserStore)

## Tecnologias

- Java
- Spring Boot
- Spring Security
- JWT (jwt)

## Documentação da API (Swagger)

A API possui documentação interativa gerada automaticamente com Swagger.

Após subir a aplicação, acesse:

- **Swagger UI:**  
  http://localhost:8080/swagger-ui.html

- **OpenAPI JSON:**  
  http://localhost:8080/v3/api-docs


## Acesso

As rotas do Swagger estão liberadas sem autenticação:

- `/v3/api-docs/**`
- `/swagger-ui/**`
- `/swagger-ui.html`

## Autenticação via JWT no Swagger

Para acessar endpoints protegidos:

1. Faça login em `/auth/login`
2. Copie o token JWT retornado
3. Clique em **Authorize** no Swagger
4. Insira:

Bearer SEU_TOKEN_AQUI

## Como rodar o projeto

```bash
# Clonar repositório
git clone <url-do-repo>

# Entrar na pasta
cd auth-service

# Rodar aplicação
./mvnw spring-boot:run