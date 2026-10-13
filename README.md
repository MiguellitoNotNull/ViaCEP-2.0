#  ViaCEP 2.0 — Buscador de CEP

Aplicação de console desenvolvida em Java para consultar endereços por meio de CEP, utilizando a API ViaCEP. O projeto permite realizar consultas, visualizar o histórico de pesquisas e gerenciar os registros armazenados localmente em JSON.

##  Funcionalidades

-  Consultar endereços por CEP.
-  Validar o formato do CEP antes da consulta.
-  Informar quando um CEP não é encontrado.
-  Visualizar o histórico de consultas.
-  Limpar o histórico com confirmação.
-  Armazenar o histórico em um arquivo JSON.
-  Evitar registros duplicados no histórico.
-  Navegar pelas funcionalidades por meio de um menu interativo.

##  Tecnologias utilizadas

- **Java** — desenvolvimento da aplicação.
- **Gson** — conversão entre objetos Java e JSON.
- **API ViaCEP** — consulta de endereços.
- **Git e GitHub** — versionamento e gerenciamento do projeto.

##  Como executar

1. Clone este repositório:

   ```bash
   git clone https://github.com/MiguellitoNotNull/ViaCEP-2.0.git
   ```

2. Abra o projeto no IntelliJ IDEA ou em outra IDE compatível com Java.

3. Verifique se o Java e a dependência Gson estão configurados corretamente.

4. Execute a classe principal do projeto.

5. Utilize o menu apresentado no terminal para realizar as consultas.

##  Armazenamento de dados

O histórico das consultas é armazenado localmente no arquivo `historico.json`. Assim, é possível consultar pesquisas anteriores e limpar o histórico quando necessário.

##  Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos de Java, consumo de APIs, manipulação de arquivos JSON, organização de classes e validação de entradas do usuário.

O ViaCEP 2.0 faz parte da minha jornada de aprendizado em **Backend Java**, buscando desenvolver habilidades práticas e construir projetos para meu portfólio.

## O que aprendi com este projeto

- Consumo de APIs utilizando Java.
- Manipulação de JSON com Gson.
- Validação de entradas do usuário.
- Leitura e escrita de arquivos para armazenar o histórico de consultas.
- Organização do código utilizando classes e métodos.

##  Autor

Desenvolvido por **Miguel**.

- **GitHub:** [MiguellitoNotNull](https://github.com/MiguellitoNotNull)
- **Repositório:** [ViaCEP 2.0](https://github.com/MiguellitoNotNull/ViaCEP-2.0)
