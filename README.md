# Ainda está em desenvolvimento 
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
- `GET /api/posts/${postId}/${likedPost}`: Busca o post por id passando um outro parâmetro se está no visualizando no feed ou perfil.
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
