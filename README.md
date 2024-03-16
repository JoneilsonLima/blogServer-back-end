# Blog Backend 
- Este repositório contém o código-fonte do backend para um blog desenvolvido com Java, Spring Boot e PostgreSQL. O backend oferece uma API RESTful para gerenciar postagens, curtidas, comentários e buscas, utilizando o PostgreSQL como banco de dados.

## Tecnologias Utilizadas
- Java
- Spring Boot
- PostgreSQL

## Funcionalidades
- CRUD de postagens
- Gestão de curtidas e comentários
- Busca por postagens

## Configuração do Ambiente
### Pré-requisitos
Antes de prosseguir, verifique se você tem os seguintes requisitos instalados em sua máquina:
- Java JDK
- Maven
- PostgreSQL

## Instalação e Configuração
- Clone este repositório:
  ```
   https://github.com/JoneilsonLima/blogServer-back-end.git
  ```
- Configure as propriedades do banco de dados PostgreSQL no arquivo 
`application.properties`

- Execute o seguinte comando para compilar e executar o projeto:
```
  mvn spring-boot:run
```

- `POST /api/posts`: Cadastra um novo post.
- `GET /api/posts`: Retorna todos os posts.
- `GET /api/posts/${postId}/${likedPost}`: Busca o post por id.
- `PUT /api/posts/${postId}/like`: Curti um post.
- `GET /api/posts/search/${name}`: Busca post pelo nome.
- `POST /api/comments/create`: Cadastra um comentário em um post.
- `GET /api/comments/${postId}`: Busca todos os comentários de um post.

## Exemplo de Requisição e Resposta
### Requisição GET /api/posts

GET /api/posts
```
[
   {
       "id": 2,
       "name": root,
       "content": exemplo,
       "postedBy": jhon,
       "img": "https://images.com/",
       "date": "2024-03-14T04:03:26.854+00:00",
       "likeCount": 12,
       "viewCount": 30,
       "tags": [
          "neve",
          "férias"
       ]
   }
]
```

## Configurações do banco de dados
Você pode criar um banco de dados com PostgreSQL com o nome o nome de sua preferência, porém é necessario adequar o projeto de acordo com as suas configurações. Para isso abra o arquivo application.properties, localizado em `src/main/resources/application.properties` e altere os seguintes comandos ao arquivo:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/postDb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```
