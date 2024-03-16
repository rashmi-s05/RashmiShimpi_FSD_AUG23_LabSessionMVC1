# Employee Management System

## Overview:
This project is an Employee Management System developed using Spring Boot and Thymeleaf. It provides functionalities to view, insert, update, and delete records from the database table.

## Setup Instructions:
1. Clone the repository to your local machine.
2. Import the project into your preferred IDE.
3. Ensure you have Maven installed and configured.
4. Configure your database settings in `application.properties`.
5. Run the project using the Spring Boot application.

## Dependencies:
- Spring Boot
- Spring Data JPA
- Thymeleaf
- Spring Web

## How to Run:
1. Navigate to the project directory.
2. Run `mvn spring-boot:run` to start the application.
3. Access the application through the browser.

## Usage:
- Upon accessing the application, users will be presented with a dashboard showing employee records.
- Users can perform the following operations:
  1. View all records from the database table.
  2. Insert new records into the table.
  3. Update an existing record in the table.
  4. Delete existing records from the table.

## Access:
- Application URL: http://localhost:8080/

## Endpoints:
- View all records: GET http://localhost:8080/employees
- Insert new record: POST http://localhost:8080/employees/new
- Update existing record: POST http://localhost:8080/employees/edit/{id}
- Delete existing record: GET http://localhost:8080/employees/delete/{id}

