<h1 align="center"> API Voll Med </h1>


## Índice

* [1. Introdução](#1-introducao)
* [2. Estrutura Geral do Projeto](#2-estrutura-geral-do-projeto)
* [3. Funcionalidades da API](#3-funcionalidades-da-api)
* [4. Objetivos de Aprendizagem](#4-objetivos-de-aprendizagem)
* [5. Tecnologias Utilizadas](#5-tecnologias-utilizadas)

***

## 1. Introdução🤩

Projeto adicionado aqui no repositório apenas para estudos.

A API Voll Med foi desenvolvida para atender as necessidades de uma clínica médica fictícia. A empresa possui uma clínica que precisa de um aplicativo para monitorar e realizar o cadastro de médicos, pacientes, além de opções para realizar agendamentos e cancelamento de consultas. Esse projeto foi desenvolvido com base nas aulas administradas pelo professor [Rodrigo Ferreira](https://github.com/rcaneppele), através do programa ONE Oracle Next Education em parceria com a Alura.


## 2. Estrutura Geral do Projeto📝

### Configurações e Dependências
 
Dependências do Spring:
* Spring Boot 
* DevTools 
* Lombok
* Spring Web
* Validation
* MySQL Driver
* Spring Data JPA
* Flyway Migration.

Dependências do Spring Doc:
* OpenAPI

### Pacotes

A aplicação foi organizada em 3 principais pacotes:

* Controller
* Domain
* Infra

No pacote `Controler` temos as classes relacionadas ao controlador responsável por fazer as requisições HTTP do sistema. No pacote `Domain` temos as classes relacionadas aos médicos, pacientes e usuários. E por fim temos o pacote `Infra` que está sendo responsável por lidar com a segurança, exceções e bibliotecas do projeto.

### Documentação da API

Pensando na utilidade da API para equipes de desenvolvimento front-end e mobile, foi aplicado com SpringDoc ao projeto a geração da sua documentação, através da utilização do Swagger para acessar uma interface gráfica, simular requisições e incluir informações de autenticação JWT.

### Testes Automatizados

Foi criado alguns testes automatizados para garantir a qualidade do código. Para testes de Controller, foi utilizado o `MockMvc` e `JacksonTester`.

### Segurança

Adicionado o Spring Security ao projeto, implementando uma autenticação e autorização por tokens JWT, sendo configurado para utilizar autenticação stateless e hashing de senhas.

### Build e Deploy

Ao finalizar o projeto foi gerado o build da aplicação via Maven, criando um arquivo `.jar` na pasta `target`, com o nome de `api-0.0.1-SNAPSHOT.jar`. Realizado a configuração dos arquivos properties e simulado um deploy, incluindo comandos e parâmetros em um ambiente de produção.


## 3. Funcionalidades da API🔍

* Cadastro de Médicos: Permite criar, ler, atualizar e deletar informações de médicos.
* Cadastro de Pacientes: Permite criar, ler, atualizar e deletar informações de pacientes.
* Agendamento de Consultas: Permite agendar consultas médicas.
* Cancelamento de Consultas: Permite cancelar consultas agendadas.

Os testes para consultas, armazenamentos e buscas foram feitos através do Framework Open Source Insomnia.

## 4. Objetivos de Aprendizagem📝

* Criando uma API do zero com o Spring utilizando recursos e dependências do Spring Initializr. 
* Criando classes, DTOs, Records, Interfaces.
* Adicionando funcionalidades, controller e repository.
* Criando migrations com Flyway.
* Trabalhando com CRUD e validações.
* Trabalhando com a qualidade do sistema aplicando testes automatizados.
* Testando banco de dados com MySQL

## 5. Tecnologias Utilizadas✅

<div>
    <img src="https://img.icons8.com/color/452/java-coffee-cup-logo--v1.png" alt="Java Logo" width="50" height="50">
    <img src="https://img.icons8.com/color/452/intellij-idea.png" alt="IntelliJ Logo" width="50" height="50">
    <img src="https://img.icons8.com/color/452/spring-logo.png" alt="Spring Boot Logo" width="50" height="50">
    <img src="https://img.icons8.com/color/452/mysql-logo.png" alt="MySQL Logo" width="50" height="50">
    <img src="https://insomnia.rest/images/insomnia-logo.svg" alt="Insomnia Logo" width="100" height="50">
</div>