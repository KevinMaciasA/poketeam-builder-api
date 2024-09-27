# Poketeam REST API

Java Spring REST API to persist data of PokeTeams using MySQL.

## Prerequisites

- Java 17
- Maven
- MySQL

## Running the Project

1. Clone the Repository

```bash
git clone https://github.com/KevinMaciasA/poketeam-builder-api.git
cd poketeam-builder-api
```

2. Add Your Database Credentials

Update the application.yaml file with your MySQL database credentials:

```bash
cd src/main/resources
```

Sample `application.yaml``

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost/poketeam_api?createDatabaseIfNotExist=true&serverTimezone=UTC
    username: YOUR_USERNAME
    password: YOUR_PASSWORD
```

3. Build and Run

```bash
   ./mvnw clean package
   java -jar target/poketeam-api-1.0.1.jar
```
