
- [Accessing Data in Pivotal GemFire](https://spring.io/guides/gs/accessing-data-gemfire/)
Learn how to build an application using Gemfire's data fabric.

```bash
# hello.gemfire

# 可以把它理解为一个增强版的Redis，具体在哪些方面增强，我们日后慢慢聊。如果你不了解Redis，也没有关系，先看官方网站上的说法：
# Pivotal GemFire is the distributed, in-memory database for developers who are building the highest scaling and performing data-centric apps in the world. 
# 但是，按照我对它的理解，我更愿意用下面的语言来描述它，GemFire是一个高性能的分布式内存对象缓存系统，如果非要说它是数据库，那也只能算是一个Key/Value数据库(我更愿意称之为Key/Value存储系统)

docker pull viniciusccarvalho/docker-gemfire
docker run -d -e HOSTNAME=192.168.59.103 -p 1099:1099 -p 8080:8080 -p 40404:40404 viniciusccarvalho/docker-gemfire

docker run -p 1099:1099 -p 8080:8080 -p 40404:40404 --name docker_gemfire -d viniciusccarvalho/docker-gemfire

```

- [Caching Data with Pivotal GemFire](https://spring.io/guides/gs/caching-gemfire/)        
Learn how to cache data in GemFire.
```bash
# hello.cache
```

- [Integrating Data](https://spring.io/guides/gs/integration/)        
Learn how to build an application that uses Spring Integration to fetch data, process it, and write it to a file.
```bash
# This guide walks you through the process of using Spring Integration to create a simple application 
#   that retrieves data from an RSS Feed (Spring Blog), manipulates the data, and then writes it to a file. 
# This guide uses traditional Spring Integration XML configuration; other guides exist showing the use of JavaConfig/DSL with and without JDK 8 Lambda expressions.

# resources.hello.integration.xml
> /tmp/si/SpringBlog

```

- [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)    
Learn how to wrap key parts of code with transactions.    
You’ll build a simple JDBC application wherein you make database operations transactional without having to write specialized JDBC code.
```bash

```



- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
Learn how to work with JPA data persistence using Spring Data JPA.

- [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
Learn how to persist data in MongoDB

- [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
Learn how to create a web page with Spring MVC and Thymeleaf.

- [Converting a Spring Boot JAR Application to a WAR](https://spring.io/guides/gs/convert-jar-to-war/)
Learn how to convert your Spring Boot JAR-based application to a WAR file.

- [Creating Asynchronous Methods](https://spring.io/guides/gs/async-method/)
Learn how to create asynchronous service methods.

- [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
   Learn how to create and submit a web form with Spring.

- [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/)
   Learn how to build an application with minimal configuration.
   
- [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)
   Learn how to the send and receive messages between a browser and the server over a WebSocket
   
- [Working a Getting Started guide with STS](https://spring.io/guides/gs/sts/)
   Learn how to import a Getting Started guide with Spring Tool Suite (STS). 
   
- [Consuming a RESTful Web Service with AngularJS](https://spring.io/guides/gs/consuming-rest-angularjs/)
   Learn how to retrieve web page data with AngularJS.     
   
- [Consuming a RESTful Web Service with rest.js](https://spring.io/guides/gs/consuming-rest-restjs/)
   Learn how to retrieve web page data with rest.js.
   
- [Consuming a RESTful Web Service with jQuery](https://spring.io/guides/gs/consuming-rest-jquery/)
   Learn how to retrieve web page data with jQuery.      
      
- [Enabling Cross Origin Requests for a RESTful Web Service](https://spring.io/guides/gs/rest-service-cors/)
   Learn how to create a RESTful web service with Spring that support Cross-Origin Resource Sharing (CORS).
   
- [Building Spring YARN Projects with Maven](https://spring.io/guides/gs/maven-yarn/) 
   Learn how to build a Spring YARN Project with Maven     