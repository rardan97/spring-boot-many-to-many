## Spring boot V3 - Many-to-Many Relationship Database

## System Requirements

- Java openjdk : ( version "17.0.2")
- Spring Boot : (version 3.3.3)
- MySQL Database
- Maven : (Apache Maven 3.9.3)
- Editor : (Intellij IDEA 2023.1.1 Community Edition)

## Dependencis

- Spring Data JPA
- Spring Web
- Spring Boot DevTools
- MySQL Driver

## run project

1. clone project Spring boot
```
https://github.com/rardan97/spring-boot-many-to-many.git
```

2. add new database mysql with name "spring-boot-many-to-many"

3. open project with intellij IDEA then edit config database in application.properties change database name, username and password match your config db

   #### location : spring-boot-many-to-many/src/main/resources/application.properties

```
spring.application.name=spring-boot-many-to-many
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/db_spring_many_to_many
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```


4. open terminal input command
```
mvn clean install 
```
5. if success, next input command
```
mvn spring-boot:run
```

## Testing project
using application postman for testing