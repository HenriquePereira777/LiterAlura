# 📚 LiterAlura — Catálogo de Livros (Oracle Next Education)

Aplicação Java de console desenvolvida como parte do **curso Oracle Next Education (ONE)**, com foco em aprendizado de **Java, Spring Boot, consumo de API REST e persistência com JPA**.

O sistema consome dados de uma API pública de livros, salva no banco de dados e permite consultas interativas via menu no terminal.

---

## 🎓 Projeto do Curso Oracle

Este projeto foi desenvolvido durante o **programa Oracle Next Education (ONE)** com o objetivo de praticar:

* Consumo de API REST
* Conversão de JSON para objetos Java
* Persistência de dados com JPA/Hibernate
* Arquitetura em camadas (Service / Repository)
* Programação orientada a objetos
* Tratamento de exceções
* Boas práticas em Java

---

## 🚀 Funcionalidades

* 🔎 Buscar livro pelo título via API externa
* 💾 Salvar livros e autores no banco de dados
* 📖 Listar livros registrados
* 👨‍💼 Listar autores registrados
* 📅 Listar autores vivos em determinado ano
* 🌍 Listar livros por idioma
* ⚠️ Tratamento de erros de entrada do usuário

---

## 🛠️ Tecnologias Utilizadas

* Java 21+
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven
* API REST (Gutendex)
* Banco de dados relacional
* Programação orientada a objetos

---

## 📡 API Utilizada

O projeto consome dados da API pública:

👉 https://gutendex.com/

---

## 📂 Estrutura do Projeto

```
src
├── model        → Entidades
├── DTO          → DTOs
├── repository   → Interfaces JPA
├── service      → Regras de negócio
└── principal    → Interface de menu (console)
```

---

## ▶️ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/HenriquePereira777/LiterAlura.git
```

### 2. Entrar na pasta do projeto

```bash
cd liter-alura
```

### 3. Executar com Maven

```bash
./mvnw spring-boot:run
```

Ou execute a classe principal pela sua IDE.

---

## 💡 Exemplo de Uso

Ao executar a aplicação, o menu será exibido:

```
****** Menu *****

1- Buscar livro pelo titulo
2- Listar livros registrados
3- Listar autores registrados
4- Listar autores vivo em um determinado ano
5- Listar livros em um determinado idioma

0- sair
```

O usuário interage digitando o número da opção desejada.

---

## 🎯 Objetivo do Projeto

O objetivo principal é consolidar os conhecimentos adquiridos no **curso Oracle Next Education**, aplicando:

* Integração com APIs externas
* Persistência em banco de dados
* Arquitetura limpa em Java
* Manipulação de dados e exceções
* Desenvolvimento de aplicações reais

---

## 🔮 Melhorias Futuras

* Interface gráfica ou versão web
* Testes unitários
* Paginação de resultados
* Logs estruturados
* Cache de consultas
* Dockerização do projeto

---

## 👨‍💻 Autor

**Henrique Pereira**

Projeto desenvolvido para fins de estudo no programa **Oracle Next Education (ONE)**.

---

## 📜 Licença

Este projeto é livre para estudo e uso educacional.
