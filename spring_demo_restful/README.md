
－ [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)

```bash

# hello.greeting 

# 1. gen mvnw
mvn -N io.takari:maven:wrapper -Dmaven=3.5.3

# 2. run and view http://localhost:8080/greeting
./mvnw spring-boot:run

# 3. compile and package  
./mvnw clean package

# 4. run and view http://localhost:8080/greeting
java -jar target/spring-rest-service-0.1.0.jar

```

- [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/) 
```bash

# hello.person

# 新增用户
curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8080/people

# 获取用户列表
curl http://localhost:8080/people

```

- 访问MySql数据[Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
    - [docker mysql img](https://store.docker.com/images/mysql)
```bash

# hello.user

# docker run -p 3306:3306 -v /opt/data/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=my-root-pwd --name mysql-spring -d mysql:5.6
# 通过另外一个docker镜像链接mysql
# docker run -it --link mysql-spring:mysql --rm mysql sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P"$MYSQL_PORT_3306_TCP_PORT" -uroot -p"$MYSQL_ENV_MYSQL_ROOT_PASSWORD"'


# Docker启动mysql，端口映射到主机
docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-root-pwd --name mysql-spring -d mysql:5.6
# 本地链接mysql
mysql> create database db_example;
mysql> DROP USER IF EXISTS "username";
mysql> create user 'username'@'%' identified by 'password';
mysql> grant all on db_example.* to 'username'@'%' IDENTIFIED BY 'password';
mysql> flush privileges;


# 模拟新增用户
curl 'localhost:8080/demo/add?name=First&email=someemail@someemailprovider.com'

# 查看用户列表
localhost:8080/demo/all


mysql> revoke all on db_example.* from 'springuser'@'localhost';
mysql> grant select, insert, delete, update on db_example.* to 'springuser'@'localhost';

# 关停服务
docker ps -a
docker stop xxx
docker rm xxx

```

- 通过JPA访问数据 [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

```bash
# hello.customer
```

- 定时任务 [Scheduling Tasks](https://spring.io/guides/gs/scheduling-tasks/)

```bash
# You’ll build an application that prints out the current time every five seconds using Spring’s @Scheduled annotation.
# hello.schedule
```

- 调用外部rest服务 [Consuming a RESTful Web Service](https://spring.io/guides/gs/consuming-rest/)
```bash
# hello.quote
```

- [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
```bash
# hello.namer
```

- [Uploading Files](https://spring.io/guides/gs/uploading-files/)
```bash
# hello.multi
#
# To upload files with Servlet containers, you need to register a MultipartConfigElement class (which would be <multipart-config> in web.xml).
 
```

- [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

```bash

# You’ll build a simple web application that is secured by Spring Security’s embedded Java-based LDAP server. 
# You’ll load the LDAP server with a data file containing a set of users.

# The @EnableWebSecurity turns on a variety of beans needed to use Spring Security.

# LDAP servers can use LDIF (LDAP Data Interchange Format) files to exchange user data. 
# The spring.ldap.embedded.ldif property inside application.properties allow to Spring Boot pulls in an LDIF data file. 
# This makes it easy to pre-load demonstration data.
  
# Enter username ben and password benspassword. You should see this message in your browser:

```


- [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
```bash
docker run -p 6379:6379 --name redis-spring -d redis
```

- [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)

```bash
docker run -p 5672:5672 -p 15672:15672  --name rabbitmq-spring -d rabbitmq

```