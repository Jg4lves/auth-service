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
- JWT (jjwt)

## Como rodar o projeto

```bash
# Clonar repositório
git clone <url-do-repo>

# Entrar na pasta
cd auth-service

# Rodar aplicação
./mvnw spring-boot:run