# 📚 Literalura

Aplicação Java desenvolvida com **Spring Boot** que consome uma API de livros, armazena os dados em um banco de dados relacional e permite consultar informações como livros e autores cadastrados.

Projeto desenvolvido com foco em prática:

* Consumo de API REST
* Persistência com JPA / Hibernate
* Relacionamentos entre entidades
* Banco de dados PostgreSQL
* Organização em camadas (Service, Repository, Model)

---

## 🚀 Funcionalidades

✅ Buscar livros pelo título através de API externa
✅ Salvar livros no banco de dados
✅ Salvar autores automaticamente
✅ Listar livros cadastrados
✅ Listar autores cadastrados
✅ Evitar duplicidade de registros
✅ Relacionamento entre Livro e Autor

---

## 🛠 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* API REST de livros

---

## 🗄 Estrutura do projeto

```
literalura
├── model
│   ├── Livro
│   └── Autor
├── repository
│   ├── LivroRepository
│   └── AutorRepository
├── service
│   └── LivroService
├── principal
│   └── Principal (menu interativo)
└── LiteraluraApplication
```

---

## ⚙️ Configuração do banco de dados

Configure o arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## ▶️ Como executar o projeto

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/seu-usuario/literalura.git
```

---

### 2️⃣ Entrar na pasta do projeto

```bash
cd literalura
```

---

### 3️⃣ Executar a aplicação

No IntelliJ ou outra IDE:

```
Run LiteraluraApplication
```

Ou via terminal:

```bash
./mvnw spring-boot:run
```

---

## 🧭 Menu da aplicação

Ao executar, o sistema apresenta um menu interativo no console:

```
1 - Buscar livro pelo título
2 - Listar livros registrados
3 - Listar autores registrados
0 - Sair
```

---

## 🔎 Como funciona a busca

1. O usuário digita o nome do livro
2. O sistema consulta a API externa
3. Os dados são convertidos em entidades
4. Autor e livro são salvos no banco
5. Relacionamento é criado automaticamente

---

## 🧠 Conceitos aplicados

* Relacionamento OneToMany / ManyToOne
* Fetch Lazy
* Transações
* Persistência automática com JPA
* Tratamento de duplicidade
* Separação de responsabilidades

---

## 📌 Melhorias futuras

⬜ Buscar livros por idioma
⬜ Buscar autores vivos em determinado ano
⬜ Estatísticas de downloads
⬜ Interface gráfica
⬜ API REST própria

---

## 👨‍💻 Autor

Projeto desenvolvido para fins de estudo em Java + Spring Boot através dos conhecimentos adquiridos pelo curso da Alura.

---

## 📄 Licença

Este projeto é livre para uso educacional.
