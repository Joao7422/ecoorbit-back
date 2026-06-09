# EcoOrbit

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

- ODS 2: Fome zero e agricultura sustentável
- ODS 9: Indústria, inovação e infraestrutura
- ODS 11: Cidades e comunidades sustentáveis
- ODS 13: Ação contra a mudança global do clima

---

## Tecnologias Utilizadas

- Java 17
- Programação Orientada a Objetos
- JDBC
- MySQL
- Maven
- React
- Tailwind CSS

---

## Funcionalidades

- Cadastro de usuários
- Listagem de usuários
- Atualização de usuários
- Exclusão de usuários
- Cadastro de áreas monitoradas
- Listagem de áreas monitoradas
- Atualização de áreas monitoradas
- Exclusão de áreas monitoradas
- Cadastro de alertas ambientais
- Listagem de alertas ambientais
- Atualização de alertas ambientais
- Exclusão de alertas ambientais

---

## Entidades do Sistema

### Usuario

Representa o usuário responsável por áreas monitoradas.

Atributos:

- id
- nome
- email
- tipo

### AreaMonitorada

Representa uma área ambiental cadastrada no sistema.

Atributos:

- id
- nome
- cidade
- estado
- tamanhoHectares
- usuarioId

### AlertaAmbiental

Representa um alerta ambiental relacionado a uma área monitorada.

Atributos:

- id
- tipo
- nivelRisco
- descricao
- dataAlerta
- areaId

---

## Relacionamentos

- Um usuário pode ter várias áreas monitoradas.
- Uma área monitorada pode ter vários alertas ambientais.

---

## Como Executar o Banco de Dados

1. Abra o MySQL Workbench.
2. Execute o arquivo `banco.sql`.
3. O script irá criar o banco `ecoorbit`, as tabelas e os dados de exemplo.

---

## Como Executar o Projeto Java

1. Abra o projeto no IntelliJ IDEA.
2. Confirme se o MySQL está rodando.
3. Verifique a classe `ConnectionFactory`.
4. Confirme os dados de conexão:

```java
private static final String URL = "jdbc:mysql://localhost:3306/ecoorbit";
private static final String USER = "ecoorbit_user";
private static final String PASSWORD = "123456";