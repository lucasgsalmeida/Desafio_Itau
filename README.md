**- Documentação do Projeto Desafio Itaú**
Este projeto é uma aplicação de demonstração que fornece endpoints para registro de transações e cálculo de estatísticas com base nas transações registradas nos últimos 60 segundos.

**- Tecnologias Utilizadas**
Java, Spring Boot, Spring Data JPA, Lombok, Maven

**- Estrutura do Projeto**
O projeto está estruturado da seguinte forma:
Desafio_Itau/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── me/
│   │   │       └── lucas/
│   │   │           └── Desafio_Itau/
│   │   │               ├── controller/            # Controladores REST
│   │   │               ├── model/
│   │   │               │   ├── domain/
│   │   │               │   │   ├── estatistica/  # Classes relacionadas a estatísticas
│   │   │               │   │   └── transacao/    # Classes relacionadas a transações
│   │   │               │   ├── repository/        # Interfaces e implementações de repositórios
│   │   │               │   └── service/          # Serviços de negócio
│   │   │               └── DesafioItauApplication.java  # Classe principal do Spring Boot
└── pom.xml                                       # Configuração do Maven


**- Descrição dos Pacotes**
controller: Contém os controladores REST responsáveis por receber requisições HTTP e delegar o processamento para os serviços apropriados.
model.domain.estatistica: Contém as classes relacionadas às estatísticas, como a classe Estatistica e EstatisticaResponseDTO.
model.domain.transacao: Contém as classes relacionadas às transações, como a classe Transacao e TransacaoRequestDTO.
repository: Contém as interfaces e implementações dos repositórios para acesso aos dados.
service: Contém os serviços de negócio que implementam a lógica de negócio da aplicação.

**- Funcionalidades Principais**
Registro de transações através do endpoint POST /transacao.
Exclusão de todas as transações através do endpoint DELETE /transacao.
Cálculo de estatísticas das transações nos últimos 60 segundos através do endpoint GET /estatistica.

**- Observações**
O projeto utiliza o Spring Boot para configuração automática e simplificação do desenvolvimento.
Lombok é usado para reduzir a verbosidade do código, fornecendo anotações para gerar automaticamente getters, setters, construtores e outros métodos comuns.
A persistência de dados é feita em memória usando listas para simplificar o projeto. Em um ambiente de produção, um banco de dados real seria usado.
