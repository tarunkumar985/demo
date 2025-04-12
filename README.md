# Spring Boot Employee Management API

## 🔧 Tech Stack

- Java 17+
- Spring Boot 3.x
- Spring Security (JWT)
- H2 Database (in-memory)
- Spring Data JPA
- MapStruct
- Actuator

---

## 🚀 Getting Started

## Build the project
./mvnw clean install



## Project Structure

src/
 └── main/
     ├── java/
     │    └── com.example.demo/
     │         ├── auth/       # JWT auth, login, filters
     │         ├── config/     # Security config, OpenAPI config
     │         ├── controller/ # REST controllers
     │         ├── dto/        # DTOs
     │         ├── entity/     # JPA entities
     │         ├── mapper/     # MapStruct mappers
     │         └── service/    # Business logic
     └── resources/
           ├── application.properties
           └── data.sql       # Sample users


## Actuator Endpoints
http://localhost:8080/actuator



## Login Endpoint
#POST:  http://localhost:8080/login

Content-Type: application/json

{
   "username": "alice",
    "password": "password123"
}


#POST:  http://localhost:8080/register

Content-Type: application/json

{
    "username":"alice",
    "password":"password123"
}

## Summary of Custom Table Names
	Auth Table Description
1. 	users	-->Stores users

2.  roles	-->Stores roles

3.  user_roles	-->Join table (many-to-many)


