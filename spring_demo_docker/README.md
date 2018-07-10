
- [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker)
Learn how to create a Docker container from a Spring Boot application with Maven or Gradle

```bash

mvn -N io.takari:maven:wrapper -Dmaven=3.5.3

# 安装
./mvnw install dockerfile:build

# 本地运行
docker run -p 8080:8080 -t springio/spring-demo-docker

# 发布
./mvnw dockerfile:push

```

