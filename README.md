# Email Sender Microservice
## Objective:
* Task is to create a Java EE application (Microservice) for a Email Sender API. The goal is to send a email from Gmail account using SMTP protocol.
* Make the controller as Endpoint in order to make it as a Micro-Webservice.
* Added Swagger UI configuration for documentation.
## Operations:
* Send email using Gmail.
* Save the sent email inside the Database.
## Components:
1. Entities, Controllers, Service and Repository layers are created.
2. Host email account(GMAIL) details are saved inside properties file in IntelliJ IDE.
3. Mail is constructed as Mime message and sent using Java Mail Sender.
4. Save the sent email in the database as well.
## Project Requirements:
* Validate HTTP request parameters.
* Implement exception handling.
* Document APIs using Spring-doc API and Swagger.
## Technical Requirements:
### Backend:
* Java 17
* Spring Boot REST
* Spring Data JPA
* Validation
* Maven
### Database:
* MySQL
### Tools:
* IntelliJ Idea
* Postman
