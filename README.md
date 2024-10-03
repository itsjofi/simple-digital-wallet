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
- [Docker](https://www.docker.com/): Platform for developing, shipping, and running applications in containers

## Getting Started

To run this project locally using Docker:

1. Clone the repository.
2. Copy the `.env.example` file to a new file named `.env` and configure the environment variables as needed.
3. Copy the `config.example.json` file to a new file named `config.json` and configure it so that pgAdmin automatically creates the server.
4. Ensure you have Docker installed.
5. Navigate to the project directory.

### Running the Application

- Build and run the application using the following command:

  ```bash
  docker-compose up --build -d
  ```

The application will start, and you can access the API endpoints through `http://localhost:8080`.

API documentation can be accessed at `http://localhost:8080/swagger-ui.html`.

### Running in Debug Mode on IntelliJ

To run the application in debug mode using IntelliJ:

1. **Set Up a Remote Debug Configuration in IntelliJ**  
   1.1. Open IntelliJ and navigate to `Run` > `Edit Configurations`.  
   1.2. Click the `+` button and select `Remote JVM Debug`.  
   1.3. Set the host to `localhost` and the port to `5005`.  
   1.4. Click `OK` to save the configuration.

2. **Start Debugging**  
   2.1. Once the application is running in Docker, you can start the remote debug configuration in IntelliJ.  
   2.2. You should now be able to set breakpoints and debug your application as needed.

## Inspiration

This project was inspired by and based on the [PicPay Backend Challenge](https://github.com/PicPay/picpay-desafio-backend).
