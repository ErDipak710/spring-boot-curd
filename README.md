

# User Management System

This is a simple yet comprehensive CRUD (Create, Read, Update, Delete) application for managing users. The application is built using the latest version of Spring Boot ,spring cache and provides a RESTful API for interacting with user data. It is designed with robust features such as user search, pagination, validation, exception handling, logging using Aspect-Oriented Programming (AOP), and more. The application also supports CORS configuration and includes API documentation with OpenAPI (Swagger UI).


### Features

1. Basic and advanced CRUD operations using the latest Spring Boot framework and Spring Cache.
2. Search users by different fields such as username, password, or active status.
3. Pagination and pagination validation for handling large data sets.
4. Logging using Aspect-Oriented Programming (AOP) for better traceability and debugging.
5. Exception handling with detailed error messages for improved resilience.
6. Validation of user input for creating and updating users.
7. In-memory H2 database for fast testing and easy setup.
8. CORS configuration for handling cross-origin requests.
9. RESTful API with detailed documentation using OpenAPI (Swagger UI).
10. Actuator endpoints for application health and metrics monitoring.

### Technology Stack

1. Java 17
2. Spring Boot 3.3.2
3. Spring Boot Starter Web
4. Spring Boot Starter Data JPA
5. Spring Boot Starter Actuator
6. Spring Boot Starter Validation
7. Spring Cache
8. H2 Database
9. Lombok
10. Springdoc OpenAPI 2.2.0

### Prerequisites

1. JDK 17 
2. Maven

### Installation

1. Clone the repository:

```shell
$ git clone https://github.com/your-username/user-management-system.git
```

2. Build the project using Maven:

```shell
$ mvn clean install

```
3. Run the application:

```shell
$ mvn spring-boot:run

```

#### Url Details

URL | Note                                   |
--- |----------------------------------------| 
http://localhost:8080/swagger-ui/index.html#/ | Visit For Api details and try working response of the api 
http://localhost:8080/actuator | for monitoring 



### Endpoints
Here are some key API endpoints:
1. Create a User: `POST /api/users`
2. Get All Users: `GET /api/users`
3. Get All Users By pagination: `GET /api/users/page/{pageNum}/{pageSize}`
4. Get User by ID: `GET /api/users/{id}`
5. Update a User: `PUT /api/users/{id}`
6. Delete a User: `DELETE /api/users/{id}`
7. Search Users by Keyword: `GET /api/users/search?keyword={keyword}`

### Actuator Monitoring
Spring Boot Actuator is included for monitoring the application. The following actuator endpoints are exposed:
1. Health Check: `http://localhost:8080/actuator/health`
2. Metrics: `http://localhost:8080/actuator/metrics`
3. All Endpoints: `http://localhost:8080/actuator` 


#### Author

<h1 align="center">Hi 👋, I'm Dipak Bohara</h1>
<h3 align="center">A Passionate Java Fullstack Developer from Nepal</h3>
