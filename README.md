# CRUD API Project

This project is a CRUD API application built with Spring Boot and PostgreSQL. It includes JWT-based authentication and is containerized using Docker.

---

## Project Summary

This API allows users to register, log in, and perform CRUD operations on user accounts.

---

## Requirements

- **Java 17**
- **Maven 3.x**
- **Docker and Docker Compose**

---

## Setup and Running

### 1. Setting Up the Application

1. **Clone the Project:**

   ```bash
   git clone https://github.com/esaricoglu/crud-api.git
   cd crud-api
   ```

### 2. Running PostgreSQL Database in Docker

1. Start PostgreSQL and the Spring Boot application using Docker Compose:

   ```bash
   docker-compose up --build
   ```

2. Verify that the containers are running:

   ```bash
   docker ps
   ```

   You should see two containers:

   - `postgres_container` (PostgreSQL)
   - `crud-api-app` (Spring Boot application)

3. Use the following credentials to connect to PostgreSQL:

   - **Host:** `database` (within Docker network) or `localhost` (for external connections)
   - **Port:** `5432`
   - **Database Name:** `crud-api`
   - **Username:** `postgres`
   - **Password:** `pgadmin`

---

## API Testing

You can test the API using Postman or cURL. Below are some examples:

### 1. User Registration

- **Endpoint:** `http://localhost:8080/register`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "username": "emin",
    "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
    "username": "emin",
    "password": "$2a$10$crypted-password"
  }
  ```

### 2. Login

- **Endpoint:** `http://localhost:8080/login`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
    "username": "emin",
    "password": "password123"
  }
  ```
- **Response:**
  ```json
  {
    "token": "<jwt-token>"
  }
  ```

### 3. List Users

- **Endpoint:** `http://localhost:8080/users`
- **Method:** `GET`
- **Authorization:** Bearer Token required.
- **Response:** Returns a list of users.

### 4. Delete User

- **Endpoint:** `http://localhost:8080/users/{id}`
- **Method:** `DELETE`
- **Authorization:** Bearer Token required.
- **Response:** No content.

### 5. Update User

- **Endpoint:** `http://localhost:8080/users/{id}`
- **Method:** `PUT`
- **Request Body:**
  ```json
  {
    "username": "emin-updated",
    "password": "newpassword123"
  }
  ```
- **Response:**
  ```json
  {
    "username": "emin-updated",
    "password": "$2a$10$crypted-password"
  }
  ```

---

## Environment Variables

The project supports the following environment variables. These can be set in `application.properties` or Docker environment variables:

### Database Connection

- `SPRING_DATASOURCE_URL=jdbc:postgresql://database:5432/crud-api`
- `SPRING_DATASOURCE_USERNAME=postgres`
- `SPRING_DATASOURCE_PASSWORD=pgadmin`

### JWT Secret Key

- `JWT_SECRET_KEY=trainee`

### Detailed Explanation:

#### How to Configure Database Connection

- `SPRING_DATASOURCE_URL` defines the JDBC URL for PostgreSQL. Ensure the hostname `database` matches the Docker Compose service name for the database.
- `SPRING_DATASOURCE_USERNAME` and `SPRING_DATASOURCE_PASSWORD` must match the credentials set in your `docker-compose.yml` file.
- If testing locally without Docker, replace `database` with `localhost`.

#### Configuring the JWT Secret Key

- `JWT_SECRET_KEY` is used to sign and verify JWT tokens. Update this value in a secure manner if deploying to production.
- Ensure the same key is used across all services that generate or verify JWT tokens.

---

## Notes

- If you encounter errors during testing, you can skip tests using the `-DskipTests` option.
- Ensure that PostgreSQL and the application are on the same network when using Docker.

