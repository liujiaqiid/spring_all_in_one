```bash

# 1. gen mvnw
mvn -N io.takari:maven:wrapper -Dmaven=3.5.3

# 2. run and view http://localhost:8080/greeting
./mvnw spring-boot:run

# 3. compile and package  
./mvnw clean package

# 4. run and view http://localhost:8080/greeting
java -jar target/spring-rest-service-0.1.0.jar


# 新增用户
curl -i -X POST -H "Content-Type:application/json" -d "{  \"firstName\" : \"Frodo\",  \"lastName\" : \"Baggins\" }" http://localhost:8080/people

# 获取用户列表
curl http://localhost:8080/people

```
