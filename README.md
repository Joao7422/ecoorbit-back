# EcoOrbit - Back-end

## Descrição do Projeto

O EcoOrbit é um MVP desenvolvido para a Global Solution 2026/1, com o objetivo de conectar a economia espacial com problemas reais da Terra.

A solução simula uma plataforma de monitoramento ambiental sustentável utilizando dados orbitais/satelitais. O sistema permite cadastrar usuários, áreas monitoradas e alertas ambientais relacionados a riscos como queimadas, desmatamento, baixa vegetação e emissão de carbono.

A proposta demonstra como dados de satélite poderiam apoiar produtores rurais, ONGs, empresas e prefeituras na tomada de decisões mais sustentáveis.

---

## Conexão com o Tema

O projeto se conecta ao tema da indústria espacial ao simular o uso de dados de satélite para monitoramento ambiental na Terra.

Em uma versão real, o sistema poderia utilizar dados orbitais para identificar riscos ambientais, acompanhar mudanças na vegetação e gerar alertas preventivos.

---

## ODS Relacionados

* ODS 2: Fome zero e agricultura sustentável
* ODS 9: Indústria, inovação e infraestrutura
* ODS 11: Cidades e comunidades sustentáveis
* ODS 13: Ação contra a mudança global do clima

---

## Tecnologias Utilizadas

* Java 17
* Maven
* Programação Orientada a Objetos
* JDBC
* MySQL
* API HTTP com Java
* IntelliJ IDEA

---

## Banco de Dados

O projeto utiliza MySQL como banco de dados relacional.

O banco possui três tabelas principais:

* usuarios
* areas_monitoradas
* alertas_ambientais

### Relacionamentos

* Um usuário pode ter várias áreas monitoradas.
* Uma área monitorada pode ter vários alertas ambientais.

Relacionamento geral:

```txt
Usuario 1 ---- N AreaMonitorada
AreaMonitorada 1 ---- N AlertaAmbiental
```

---

## Entidades do Sistema

### Usuario

Representa o usuário responsável por áreas monitoradas.

Atributos:

* id
* nome
* email
* tipo

### AreaMonitorada

Representa uma área ambiental cadastrada no sistema.

Atributos:

* id
* nome
* cidade
* estado
* tamanhoHectares
* usuarioId

### AlertaAmbiental

Representa um alerta ambiental relacionado a uma área monitorada.

Atributos:

* id
* tipo
* nivelRisco
* descricao
* dataAlerta
* areaId

---

## Funcionalidades do Back-end

* Cadastro de usuários
* Listagem de usuários
* Atualização de usuários
* Exclusão de usuários
* Cadastro de áreas monitoradas
* Listagem de áreas monitoradas
* Atualização de áreas monitoradas
* Exclusão de áreas monitoradas
* Cadastro de alertas ambientais
* Listagem de alertas ambientais
* Atualização de alertas ambientais
* Exclusão de alertas ambientais
* API para integração com o front-end React

---

## API

A API foi desenvolvida em Java e roda localmente na porta 8080.

URL base:

```txt
http://localhost:8080
```

### Rotas disponíveis

#### Listar usuários

```txt
GET /usuarios
```

Exemplo:

```txt
http://localhost:8080/usuarios
```

#### Listar áreas monitoradas

```txt
GET /areas
```

Exemplo:

```txt
http://localhost:8080/areas
```

#### Listar alertas ambientais

```txt
GET /alertas
```

Exemplo:

```txt
http://localhost:8080/alertas
```

Essas rotas retornam dados em formato JSON para serem consumidos pelo front-end.

---

## Integração com o Front-end

O front-end em React consome os dados da API local.

Fluxo da aplicação:

```txt
React Front-end
      ↓
API Java
      ↓
JDBC
      ↓
MySQL
```

O dashboard do front-end utiliza as rotas da API para exibir:

* total de usuários cadastrados;
* total de áreas monitoradas;
* total de alertas ambientais;
* total de alertas críticos.

---

## Como Executar o Banco de Dados

1. Abra o MySQL Workbench.
2. Execute o arquivo `banco.sql`.
3. O script irá criar o banco `ecoorbit`, as tabelas e os dados de exemplo.

---

## Como Executar o Back-end

1. Abra o projeto no IntelliJ IDEA.
2. Confirme se está utilizando Java 17.
3. Confirme se o MySQL está rodando.
4. Execute o arquivo `banco.sql` no MySQL Workbench.
5. Verifique a classe `ConnectionFactory`.

Configuração esperada:

```java
private static final String URL = "jdbc:mysql://localhost:3306/ecoorbit";
private static final String USER = "ecoorbit_user";
private static final String PASSWORD = "123456";
```

6. Execute a classe `ApiServer`.
7. A API ficará disponível em:

```txt
http://localhost:8080
```

---

## Como Testar a API

Com o `ApiServer` rodando, acesse no navegador:

```txt
http://localhost:8080/usuarios
```

```txt
http://localhost:8080/areas
```

```txt
http://localhost:8080/alertas
```

Se aparecerem dados em JSON, a API está funcionando corretamente.

---

## Estrutura do Projeto

```txt
EcoOrbit
├── src
│   └── main
│       └── java
│           └── br
│               └── com
│                   └── ecoorbit
│                       ├── api
│                       │   └── ApiServer.java
│                       ├── app
│                       │   └── Main.java
│                       ├── dao
│                       │   ├── UsuarioDAO.java
│                       │   ├── AreaMonitoradaDAO.java
│                       │   └── AlertaAmbientalDAO.java
│                       ├── factory
│                       │   └── ConnectionFactory.java
│                       └── model
│                           ├── Usuario.java
│                           ├── AreaMonitorada.java
│                           └── AlertaAmbiental.java
├── banco.sql
├── pom.xml
└── README.md
```

---

## Observação

Os dados ambientais utilizados no MVP são simulados. O objetivo é demonstrar como uma solução baseada em dados orbitais poderia funcionar em uma aplicação real.

O projeto demonstra a integração entre banco de dados, back-end Java e front-end React, representando uma solução tecnológica voltada ao monitoramento ambiental sustentável.
