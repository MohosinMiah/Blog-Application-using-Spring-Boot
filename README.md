## Blog-Application-using-Spring-Boot
Blog Application using Spring Boot 
Feature : Full Blog functionality with Spring Role Permission Based Security Using JWT

## How to run this project
01. First clone the project
```
clone https://github.com/MohosinMiah/Blog-Application-using-Spring-Boot.git
```
02. Then run project 
http://localhost:8080

## API Resource and Documentation

### API Documentation
https://documenter.getpostman.com/view/4954358/2s946k7qun



## Database


## Project Feature 

# Project Name: Spring Blog with Role-Based Security

This project aims to provide a fully functional blog application with features like creating and managing posts, commenting on posts, and organizing posts by categories. The application is secured using Spring Security with Role-Based Access Control (RBAC) and employs JSON Web Tokens (JWT) for authentication.

## Features

1. **User Registration and Login**: Users can register an account and log in to the application using their credentials.

2. **Role-Based Security**: The application uses Role-Based Access Control (RBAC) to define different levels of access for users. The roles typically include `ROLE_USER`, `ROLE_ADMIN`, etc.

3. **JSON Web Tokens (JWT) Authentication**: JWT is used for authentication, ensuring secure communication between the client and server.

4. **Create and Manage Blog Posts**: Authenticated users can create, edit, and delete their blog posts.

5. **Comments on Posts**: Users can add comments to blog posts to engage in discussions.

6. **Categorize Posts**: Blog posts can be organized into different categories for easy navigation and filtering.

## Tech Stack

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL (or any other database of your choice)
- Thymeleaf (or any other templating engine of your choice for frontend rendering)
- JSON Web Tokens (JWT) for authentication
- HTML, CSS, JavaScript for frontend

## Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/spring-blog.git
```

2. Configure the database connection in `application.properties`:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/blogapplication
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true
```

3. Run the application:

```bash
mvn spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## Usage

1. Visit the application in your browser.

2. Register a new account or log in if you already have one.

3. Explore the blog posts, create new posts, and add comments.

4. Admin users (with appropriate roles) will have additional privileges, such as managing users and categories.

Thank you 
Happy coding :)



