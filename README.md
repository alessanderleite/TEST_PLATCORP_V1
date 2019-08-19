# CRUD Rest com Spring Boot

Introdução:

    Esse projeto foi desenvolvido com o objetivo de criar um CRUD REST com SPRING BOOT. 

Ferramentas Utilizadas:

    Java 1.8
    Eclipse IDE
    Spring Boot
    Spring Data JPA
    Spring Clound OpenFeign
    Maven
    MySQL Server
    Postman
    
Serviços:
    
    API aberta de geolocalização por IP https://www.ipvigilante.com/
    API aberta de clima por geolocalização https://www.metaweather.com/api/

Endpoints REST:

    POST
    http://localhost:8080/api/v1/criar - Criar um Cliente
        
    PUT
    http://localhost:8080/alterar - Alterar um Cliente

    GET
    http://localhost:8080/consultar - Listar todos os Clientes
    http://localhost:8080/consultar/{id} - Consultar um Cliente por id
        
    DELETE 
    http://localhost:8080/remover/{id} - Remover Cliente por id
