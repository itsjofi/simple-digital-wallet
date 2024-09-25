# Simple Digital Wallet

This project is a simple implementation of a digital wallet system.

## Description

The Simple Digital Wallet is a backend application that simulates basic operations of a digital wallet. It allows users to perform transactions, manage their balance, and interact with a simple financial system.

Key features include:

- User registration and management
- Money transfers between users
- Transaction history

## Technologies Used

This project is built using the following technologies:

- [Spring Boot](https://spring.io/projects/spring-boot): Java-based framework for creating stand-alone, production-grade applications
- [Java](https://www.java.com/): Programming language
- [Maven](https://maven.apache.org/): Dependency management and build automation tool
- [PostgreSQL](https://www.postgresql.org/): Open-source relational database
- [Flyway](https://flywaydb.org/): Database migration tool for versioning and managing migrations
- [Jasypt](http://www.jasypt.org/): Library for encrypting sensitive information such as passwords
- [OpenFeign](https://github.com/OpenFeign/feign): Declarative HTTP client for accessing external clients
- [JPA (Java Persistence API)](https://jakarta.ee/specifications/persistence/): Standard for ORM in Java applications
- [Swagger](https://swagger.io/): Documentation tool for API specifications

## Getting Started

To run this project locally:

1. Clone the repository
2. Copy the `.env.example` file to a new file named `.env` and configure the environment variables as needed.
3. Ensure you have Java and Maven installed
4. Navigate to the project directory
5. Run `mvn spring-boot:run`

The application will start, and you can access the API endpoints through `http://localhost:8080`.

API documentation can be accessed at `http://localhost:8080/swagger-ui`.

## Inspiration

This project was inspired by and based on the [PicPay Backend Challenge](https://github.com/PicPay/picpay-desafio-backend).
