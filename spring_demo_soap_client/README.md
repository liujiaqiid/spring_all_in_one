
## SOAP

- [Producing a SOAP web service](https://spring.io/guides/gs/producing-web-service/)
Learn how to create a SOAP-based web service with Spring.

```bash
You will build a server that exposes data from various European countries using a WSDL-based SOAP web service.

1. SOAP 
SOAP (originally Simple Object Access Protocol) is a messaging protocol specification 
 for exchanging structured information in the implementation of web services in computer networks. 
Its purpose is to induce extensibility, neutrality and independence.
It uses XML Information Set for its message format, and relies on application layer protocols, 
 most often Hypertext Transfer Protocol (HTTP) or Simple Mail Transfer Protocol (SMTP), 
 for message negotiation and transmission.

2. WSDL
WSDL stands for Web Services Description Language
WSDL is used to describe web services
WSDL is written in XML
WSDL is a W3C recommendation from 26. June 2007
An WSDL document describes a web service. 
It specifies the location of the service, and the methods of the service.

# hello.soap
# 必需compile，否则会出现io.spring.guides引入问题
mvn compile 
mvn run

# 模拟测试
curl --header "content-type: text/xml" -d @src/main/resources/request.xml http://localhost:8080/ws
 
```

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