# Java Order Management System (Spring Boot + H2)

A Spring Boot REST API to manage Products and Orders using H2 in-memory database.

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 (in-memory)
- Maven
- OpenAPI (Swagger UI)

## Features
- CRUD operations for Products
- Create Orders containing multiple products
- Fetch orders and order details
- Simple validation and error handling
- OpenAPI docs at `/swagger-ui.html`

## Run locally
```bash
mvn clean package
mvn spring-boot:run
```

Open:
- API root: http://localhost:8080/api
- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:omsdb)

## Example endpoints
- `GET /api/products`
- `POST /api/products`
- `GET /api/orders`
- `POST /api/orders`

## Notes
- The project uses in-memory H2 DB for easy testing. To switch to MySQL/Postgres edit `application.properties`.
- Author: Vivek S. Patwardhan
