# Projeto

## rodando o projeto

Após fazer o download do código, faça o seguinte:

```
mvn clean install
cd target
java -jar properties-1.0.0-SNAPSHOT.jar
```

## teste

Você pode testar de duas formas:

1- via web acessando o swagger http://localhost:8080/swagger-ui.html
Nesta opção aparecerá uma tela web para que você possa inserir os dados a partir de um formulário.

2- via terminal linux através do comando curl: 

Exemplo POST:

```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "baths": 2, \ 
   "beds": 3, \ 
   "description": "teste", \ 
   "price": 455000, \ 
   "squareMeters": 87, \ 
   "title": "teste", \ 
   "x": 500, \ 
   "y": 800 \ 
 }' 'http://localhost:8080/properties'
 ```
 
 Exemplo GET:
 
 ```
 curl -X GET --header 'Accept: application/json' 'http://localhost:8080/properties/1'
 
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/properties/?ax=0&ay=1000&bx=600&by=500'
 ```