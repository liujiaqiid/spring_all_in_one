
注意：redis 和 spring－cache不能同时使用，需要手工禁用一个

## Info
- [~~Building an Application with Spring Boot~~](https://spring.io/guides/gs/spring-boot/)
   Learn how to build an application with minimal configuration.  
- [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)
   Learn how to the send and receive messages between a browser and the server over a WebSocket
```bash
# This guide walks you through the process of creating a "hello world" application that sends messages back and forth, between a browser and the server. 
# WebSocket is a very thin, lightweight layer above TCP. It makes it very suitable to use "subprotocols" to embed messages. 
# In this guide we’ll dive in and use STOMP messaging with Spring to create an interactive web application.

# You’ll build a server that will accept a message carrying a user’s name. 
# In response, it will push a greeting into a queue that the client is subscribed to.

# hello.websocket

http://localhost:8080/socket.html
```
- [~~Working a Getting Started guide with STS~~](https://spring.io/guides/gs/sts/)
Learn how to import a Getting Started guide with Spring Tool Suite (STS).    
- [~~Consuming a RESTful Web Service with AngularJS~~](https://spring.io/guides/gs/consuming-rest-angularjs/)
Learn how to retrieve web page data with AngularJS.        
- [~~Consuming a RESTful Web Service with rest.js~~](https://spring.io/guides/gs/consuming-rest-restjs/)
Learn how to retrieve web page data with rest.js.
   
- [~~Consuming a RESTful Web Service with jQuery~~](https://spring.io/guides/gs/consuming-rest-jquery/)
Learn how to retrieve web page data with jQuery.      
- [Enabling Cross Origin Requests for a RESTful Web Service](https://spring.io/guides/gs/rest-service-cors/)
   Learn how to create a RESTful web service with Spring that support Cross-Origin Resource Sharing (CORS).
```bash
# hello.cros
```   
- [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
Learn how to work with RESTful, hypermedia-based data persistence using Spring Data REST.
```bash
# hello.rest 
```
- [~~Accessing Neo4j Data with REST~~](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
- [~~Accessing MongoDB Data with REST~~](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
- [~~Accessing Data in Pivotal GemFire with REST~~](https://spring.io/guides/gs/accessing-gemfire-data-rest/)
- [Accessing Data Reactively with Redis](https://spring.io/guides/gs/spring-data-reactive-redis/)
```bash
# hello.redis
docker run -p 6379:6379 --name redis-server -d redis
```
- [Caching Data with Spring](https://spring.io/guides/gs/caching/)
Learn how to cache data in memory with Spring
```bash
# hello.cache
```
- [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
Learn how to create a SOAP-based web service with Spring.
- [Consuming a SOAP web service](https://spring.io/guides/gs/consuming-web-service/)
Learn how to create a client that consumes a WSDL-based service
- [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker)
Learn how to create a Docker container from a Spring Boot application with Maven or Gradle


## YARN

- [Building Spring YARN Projects with Maven](https://spring.io/guides/gs/maven-yarn/) 
   Learn how to build a Spring YARN Project with Maven     
```bash

```   
- [Simple YARN Application](https://spring.io/guides/gs/yarn-basic/)
Learn how to build a simple Spring YARN application
```bash
```
- [Simple Single Project YARN Application](https://spring.io/guides/gs/yarn-basic-single/)
Learn how to build a simple Spring YARN application
- [Testing YARN Application](https://spring.io/guides/gs/yarn-testing/)
Learn how to test a Spring YARN application
```bash
```
- [Batch YARN Application](https://spring.io/guides/gs/yarn-batch-processing/)
Learn how to build a Spring Batch YARN application
```bash
```
- [Restartable Batch YARN Application](https://spring.io/guides/gs/yarn-batch-restart/)
Learn how to build a restartable Spring Batch YARN application
```bash
```