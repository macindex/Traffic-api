# 🚀 Construindo uma REST API com Spring Boot

Bem-vindo(a) a este projeto que tem como objetivo ensinar e demonstrar, na prática, como desenvolver uma **REST API robusta e bem estruturada utilizando Spring Boot**. Ao longo deste projeto, você terá contato com os fundamentos da arquitetura REST, o ecossistema Spring e boas práticas de desenvolvimento de APIs modernas.

---

## 🌟 Fundamentos de REST e Spring

### 👋 Boas-vindas e as oportunidades do mercado
Antes de tudo, é importante entender como o desenvolvimento de APIs REST se tornou uma habilidade essencial no mercado atual — e como dominá-la pode alavancar sua carreira.

### 🧑‍💻 Quem é você? Quem sou eu?
Sou Claudio e criei esse projeto com o intuito reunir um pouco de tudo que o Spring tem a nos fornecer, claro que é uma parte do que a linguagem tem a nos proporcionar, mas vou tentar ao longo do tempo atualizar este repositório para agregar mais conhecimento dentro deste material.

### 🤝 Alguns combinados antes de continuar
Vamos alinhar expectativas e boas práticas para tirar o melhor proveito do projeto!

### ❓ O que é uma API?
Entenda o conceito de Interface de Programação de Aplicações — peça-chave para integrar sistemas.

### 🌐 O que é REST?
REST é um estilo arquitetural que rege como APIs devem ser projetadas para serem simples, escaláveis e eficientes.

### 📡 Conhecendo o protocolo HTTP
Aprenda os fundamentos do HTTP — métodos, cabeçalhos, status codes — base de qualquer API RESTful.

### 📦 Entendendo os Recursos REST
O que são os recursos, como identificá-los e mapeá-los corretamente nas suas rotas e endpoints.

### 🧩 Identificando recursos REST
Exercícios práticos para treinar o reconhecimento e mapeamento de recursos.

### 🌱 Por que Spring?
Conheça os motivos pelos quais o Spring Boot é uma das ferramentas mais utilizadas para construir APIs Java.

### 🌳 Conhecendo o ecossistema de projetos Spring
Explore o universo Spring: Spring Boot, Spring Data, Spring Web, Spring Security, e outros.

### 📚 Estudos de caso
Aplicações reais e cenários onde REST e Spring são aplicados com sucesso.

---

## 🏗️ Construindo uma REST API

### 💻 Preparando o ambiente de desenvolvimento
Instalação e configuração das ferramentas essenciais.

### 📐 Conhecendo o modelo de domínio do projeto
Visão geral da estrutura de dados e entidades principais.

### 🛠️ Alternativas para criar projetos Spring Boot
Spring Initializr, CLI, IDEs — você escolhe!

### 🚀 Criando o projeto com Spring Initializr
Gerando seu projeto do zero com as dependências corretas.

### 🗂️ Entendendo a estrutura do projeto Maven
Explicando o propósito de cada diretório e arquivo importante.

### 📦 Gerando o FatJAR e iniciando a aplicação
Empacotando e executando a aplicação de forma independente.

### 🔄 Implementando e testando a requisição de um recurso
Primeiro endpoint no ar!

### 📚 Implementando uma Collection Resource
Listando dados com boas práticas REST.

### 🧰 Configurando e usando o Lombok
Menos boilerplate, mais produtividade.

### 🔢 Métodos e códigos de status HTTP
Entenda como e quando usar cada um.

### ⚙️ Content Negotiation
Retornando JSON, XML ou outros formatos, conforme a necessidade do cliente.

### ⚡ Turbinando a produtividade com DevTools
Reload automático e outras facilidades para acelerar o desenvolvimento.

---

## 💾 Persistindo os dados

### 🛠️ Configurando a conexão com o banco de dados no projeto
Integrando um banco relacional à sua aplicação.

### 🔄 Conhecendo e adicionando o Flyway no projeto
Versionamento e controle de mudanças no banco.

### 🧱 Criando a primeira migration com Flyway

### 🧬 Conhecendo o Jakarta Persistence (JPA)

### 📌 Mapeando entidades com Jakarta Persistence

### 🔍 Implementando uma consulta com JPQL

### 🗃️ Conhecendo o Spring Data JPA (SDJ) e criando um repositório

### 📥 Injetando e usando o repositório do SDJ

### 🧠 Implementando Query Methods no repositório

### 🔎 Implementando endpoint de busca de recurso

### ➕ Implementando endpoint de inclusão de recurso

### ♻️ Implementando endpoint de atualização de recurso

### ❌ Implementando endpoint de exclusão de recurso

---

## 📈 Evoluindo a API

### ✅ Conhecendo e adicionando Jakarta Bean Validation no projeto

### ✋ Validando entrada de dados com Jakarta Bean Validation

### 🧭 Implementando Domain Services

### 🚫 Implementando regra de negócio para restringir e-mails duplicados

### 🛑 Capturando exceções do controlador com @ExceptionHandler

### 🧱 Adicionando migration para criação da tabela de veículos

### 🚗 Criando e mapeando a entidade de veículo

### 🔍 Implementando os endpoints de consulta de veículos

### ➕ Implementando o endpoint de inclusão de veículos

### 🧠 Implementando regras de negócio no cadastro de veículos

### 🔐 Protegendo propriedades somente-leitura

### 🔁 Validando em cascata

### 🧪 Validando com Validation Groups

---

## 🧠 Aplicando as boas práticas

### 🛡️ Capturando exceções globais com @RestControllerAdvice

### 📄 Usando a RFC 7807 (Problem Details for HTTP APIs)

### 🎨 Customizando as informações do ProblemDetail

### 🔧 Adicionando campos customizados no ProblemDetail

### 💬 Customizando as mensagens de validação

### ⚙️ Tratando exceções customizadas de forma global

### ⏰ Boas práticas para trabalhar com data/hora

### 🔀 Isolando o Domain Model do Representation Model

### 🧱 Criando o Representation Model do recurso de veículo

### 🔁 Transformando objetos com ModelMapper

### 🧰 Implementando assembler de Representation Model

### 🧩 Compondo objetos no Representation Model

### 📥 Criando um Representation Model para entrada de dados

---

## 🔧 Modelando sub-recursos e ações não-CRUD

### 🚓 Criando e mapeando a entidade de autuação

### 🛠️ Implementando serviço de autuação

### 🧵 Modelando sub-recursos

### 📝 Implementando o endpoint de cadastro do recurso de autuação

### ❗ Especializando a exceção de entidade não encontrada

### 📦 Implementando recurso de coleção de autuações

### 🚫 Implementando regras de negócio de apreensão de veículo

### 🎯 Modelando ações não-CRUD

### 🔄 Implementando endpoints de ações não-CRUD

---

## 📌 Conclusão

Este projeto é uma jornada completa por todas as fases do desenvolvimento de uma API REST com Spring Boot — da teoria à prática, da criação à maturidade. Boa aprendizagem e, principalmente, **boas implementações!**
