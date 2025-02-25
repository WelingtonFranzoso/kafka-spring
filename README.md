# Spring Boot com Kafka

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/WelingtonFranzoso/kafka-spring/blob/main/LICENSE) 

# Sobre o projeto

Este projeto consiste em dois microserviços desenvolvidos em Java, utilizando o Spring Boot e Apache Kafka. O sistema é composto por um Producer, responsável por enviar mensagens contendo informações sobre uma entidade PersonDTO, que é compartilhada entre os dois microserviços por meio de uma biblioteca comum (lib-commons). Essas mensagens são enviadas para uma fila RabbitMQ, onde são consumidas por um Consumer, que processa as informações.

# Funcionalidades
- Envio de mensagens para o Kafka através de um Producer.
- Processamento das mensagens por um Consumer.
- Configuração dinâmica de tópicos no Kafka.
- API REST para envio de eventos de usuários.
- Registro de logs detalhados sobre envio e recebimento de mensagens.

# Tecnologias utilizadas

- Java 17+
- Spring Boot
- Maven
- Spring Kafka
- Apache Kafka
- Lombok
- Log4j2
- Docker

# Como executar o projeto
## Back end
### Pré-requisitos: 
- Java 17 ou superior
- Maven (para construção do projeto)

```bash
# clonar repositório
git clone git@github.com:WelingtonFranzoso/kafka-spring.git

# entrar na pasta do projeto back end
cd kafka-spring

# Subindo um ambiente Kafka via Docker
docker-compose up -d

# entrar na pasta do projeto Producer
cd kafka-producer

# executar o projeto
./mvnw spring-boot:run

# entrar na pasta do projeto Consumer
cd kafka-consumer

# executar o projeto
./mvnw spring-boot:run
```

# Endpoints Disponíveis

| Método | Endpoint      | Descrição             |
|:------:|:-------------:|:---------------------:|
| Post    | /people      | Envia uma mensagem com as informações da classe PersonDTO para o kafka |


# Contribuição

1. Fork este repositório

2. Crie uma branch (feature-nova)

3. Commit suas mudanças (git commit -m 'Add nova feature')

4. Push para sua branch (git push origin feature-nova)

5. Crie um Pull Request

# Licença

- Este projeto está sob a licença MIT. Sinta-se livre para usá-lo e modificá-lo.
