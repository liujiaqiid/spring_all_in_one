
- Hello world

```bash

# 1. gen mvnw
mvn -N io.takari:maven:wrapper -Dmaven=3.5.3

# 2. run and view http://localhost:8080/greeting
./mvnw spring-boot:run

# 3. compile and package  
./mvnw clean package

# 4. run and view http://localhost:8080/greeting
java -jar target/spring-rest-service-0.1.0.jar

```

- MongoDB CRUD 
```bash

# 新增用户
curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8080/people

# 获取用户列表
curl http://localhost:8080/people

```

- Mysql CRUD
    - [docker mysql img](https://store.docker.com/images/mysql)
```bash
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

# 关停服务
docker ps -a
docker stop xxx
docker rm xxx

```
