Welcome to theBack-end Assignment repository! This project is a Spring Boot microservice designed to handle the opening of new current accounts for existing customers and retrieving customer information. 
It follows industry best practices for software development and enterprise-level architecture.

## Table of Contents

## Features
Exposes RESTful endpoints for opening new current accounts and retrieving customer information.
Implements layered architecture with separate components for controllers, services, repositories, and models.
Utilizes Spring Boot for rapid development and dependency injection.
Implements validation and error handling for robustness.
Ensures testability with comprehensive unit and integration tests.
Provides clear documentation and README for easy understanding and contribution.
Prerequisites
Before running the application, make sure you have the following prerequisites installed:

## Prerequisites
Java 17 or higher
Maven 3.6.3 or higher
Git

## Getting Started
To get started with the project, follow these steps:

 1. Clone the repository:
 2. Copy code
        git clone https://github.com/mojallal68/DemoProject.git
 3. Navigate to the project directory:
 4. cd blue-harvest-backend
 5. Build the project using Maven:
     mvn clean install
 6. Run the application by starting springboot application:
 7. Access the application using the base URL: http://localhost:8080/frontend.html

## Project Structure
The project follows a standard Maven project structure:

src/main/java: Contains the Java source code.
com.assignment.demo: Root package for the application.
controller: Contains REST controller classes.
service: Contains service classes implementing business logic.
model: Contains entity and DTO classes.
exceptions: Contains custom exception classes.
src/test/java: Contains unit and integration test classes.
src/main/resources: Contains application properties and configuration files.
target: Contains compiled classes and generated JAR file.
Configuration
The application can be configured using properties files located in the src/main/resources directory. Common configuration options logging levels, and default server port(8080).

## Endpoints
The application exposes the following RESTful endpoints:

POST /openAccount: Opens a new current account for an existing customer.
GET /customer/{customerId}: Retrieves customer information, including name, surname, balance, and transactions.

## Testing
The project includes comprehensive unit and integration tests to ensure the reliability and correctness of the code. Unit tests are located in the src/test/java directory and can be executed using Maven:


## Logging and Monitoring
The application utilizes Log4j for logging purposes. Log files are generated in the logs directory and contain information about application events, errors, and warnings.
For monitoring, you can integrate the application with monitoring solutions such as Prometheus and Grafana to collect metrics and visualize performance data.