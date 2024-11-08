# API Gestão de Clientes ODONTOPREV

## 1. Apresentação do Grupo

## Integrantes da equipe:

RM554328 - João Vitor de Santana dos Santos

- Desenvolvimento do backend
- Versionamento do projeto

RM552671 - Willian Daniel Oliveira Dantas

- Desenvolvimento do backend
- Estruturação dos endpoints

RM554021 - Sara Ingrid da Silva

- Modelagem das entidades
- Liderança da entrega
- Desenvolvimento do backend


## 2. Instruções para Rodar a Aplicação

### Pré-requisitos
- Java 11+
- Maven
- Banco de dados Oracle

### Passos para Rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/jvs4nt/SPRINT1_JAVA_EVOTECH.git
   cd SPRINT1_JAVA_EVOTECH
   
Configure o banco de dados:

Certifique-se de que o banco de dados Oracle esteja em execução.
Atualize as credenciais no arquivo application.yml.


Compile e execute a aplicação:

  ```bash
mvn clean install
mvn spring-boot:run

Acesse a aplicação que estará disponível em 
http://localhost:8080
```

## 3. Endpoints
### Todos estão organizados com links do Hateoas para facilitar a navegação

### Cliente

- **GET** `/clientes`: Retorna todos os clientes.
- **GET** `/clientes/{id}`: Retorna um cliente pelo ID.
- **POST** `/clientes`: Cria um novo cliente.
- **PUT** `/clientes/{id}`: Atualiza um cliente existente.
- **DELETE** `/clientes/{id}`: Deleta um cliente pelo ID.

### Atendimento

- **GET** `/atendimentos`: Retorna todos os atendimentos.
- **GET** `/atendimentos/{id}`: Retorna um atendimento pelo ID.
- **POST** `/atendimentos`: Cria um novo atendimento.
- **PUT** `/atendimentos/{id}`: Atualiza um atendimento existente.
- **DELETE** `/atendimentos/{id}`: Deleta um atendimento pelo ID.

### Tratamento

- **GET** `/tratamentos`: Retorna todos os tratamentos.
- **GET** `/tratamentos/{id}`: Retorna um tratamento pelo ID.
- **POST** `/tratamentos`: Cria um novo tratamento.
- **PUT** `/tratamentos/{id}`: Atualiza um tratamento existente.
- **DELETE** `/tratamentos/{id}`: Deleta um tratamento pelo ID.
- 
### Rede Credenciada

- **GET** `/rede-credenciada`: Retorna todos os tratamentos.
- **GET** `/rede-credenciada/{id}`: Retorna um tratamento pelo ID.
- **POST** `/rede-credenciada`: Cria um novo tratamento.
- **PUT** `/rede-credenciada/{id}`: Atualiza um tratamento existente.
- **DELETE** `/rede-credenciada/{id}`: Deleta um tratamento pelo ID.

## 4. Imagens dos diagramas

- <img width="826" alt="image" src="https://github.com/user-attachments/assets/a0fe22b6-e533-4fd3-b3e6-300a9a9c4c18">

- <img width="923" alt="image" src="https://github.com/user-attachments/assets/29f6afc2-defe-40f1-87cc-f2fb48a31e7c">

