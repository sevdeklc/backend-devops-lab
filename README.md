# Backend DevOps Lab

A practical learning repository for building, containerizing, deploying, and monitoring a production-style Java backend application.

This repository documents my step-by-step journey of learning Java Backend Development and DevOps using Spring Boot, PostgreSQL, Docker, Jenkins, Kubernetes, Prometheus, and Grafana.

---

## 🎯 Project Goal

The goal of this repository is to build a complete backend application and gradually improve it with real-world DevOps practices.

Current application:

**Task Manager API**

A Spring Boot REST API for managing tasks with full CRUD operations, validation, PostgreSQL persistence, Docker support, and Spring Boot Actuator.

---

## 🛠 Tech Stack

* Java 21
* Spring Boot 3
* Maven
* Spring Web
* Spring Data JPA
* PostgreSQL
* Bean Validation
* Lombok
* Spring Boot Actuator
* OpenAPI
* Swagger UI
* Scalar API Reference
* JUnit 5
* Mockito
* MockMvc
* H2 Database
* Docker
* Docker Compose
* pgAdmin
* Jenkins
* Kubernetes
* Prometheus
* Grafana

---

## 📁 Project Structure

```text
backend-devops-lab
├── .env.example
├── api-docs/
│   ├── curl-examples.md
│   └── postman/
│       └── task-manager-api.postman_collection.json
├── docker-compose.yml
├── docker/
├── docs/
└── task-manager-api/
    ├── Dockerfile
    ├── pom.xml
    └── src/main/java/dev/backendlab/taskmanager/
        ├── controller/
        ├── dto/
        ├── entity/
        ├── exception/
        ├── mapper/
        ├── repository/
        └── service/
```

---

## ✅ Features Implemented

* Spring Boot Maven project
* Layered Architecture
  * Controller
  * Service
  * Repository
  * DTO
  * Mapper
  * Entity
* PostgreSQL integration
* Dockerfile
* Docker Compose
* pgAdmin
* Environment variable based configuration
* `.env` and `.env.example`
* CRUD REST API
* Bean Validation
* Global Exception Handling
* Standard Error Response
* Spring Boot Actuator
  * `/actuator/health`
  * `/actuator/info`
* API Documentation
  * cURL Examples
  * Postman Collection
  * Swagger UI
  * Scalar API Reference
  * OpenAPI Specification
* Automated Tests
  * Service Unit Tests
  * Controller Tests with MockMvc
  * Global Exception Handler Tests
  * Repository Tests with `@DataJpaTest`

---

## 🚀 Running the Project

### 1. Clone repository

```bash
git clone <repository-url>
cd backend-devops-lab
```

---

### 2. Create .env file

```bash
cp .env.example .env
```

Example:

```env
POSTGRES_DB=task_manager_db
POSTGRES_USER=task_user
POSTGRES_PASSWORD=task_password

SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/task_manager_db
SPRING_DATASOURCE_USERNAME=task_user
SPRING_DATASOURCE_PASSWORD=task_password

PGADMIN_DEFAULT_EMAIL=admin@backendlab.dev
PGADMIN_DEFAULT_PASSWORD=admin
```

---

### 3. Start containers

```bash
docker compose up --build
```

or

```bash
docker compose up --build -d
```

---

### 4. Stop containers

```bash
docker compose down
```

Remove volumes as well:

```bash
docker compose down -v
```

---

## 🗄 pgAdmin

Open:

```text
http://localhost:5050
```

Login:

```text
Email: admin@backendlab.dev
Password: admin
```

Create Server

| Setting  | Value           |
| -------- | --------------- |
| Host     | postgres        |
| Port     | 5432            |
| Database | task_manager_db |
| Username | task_user       |
| Password | task_password   |

---

## 📌 REST API

Base URL

```text
http://localhost:8080
```

| Method | Endpoint      | Description    |
| ------ | ------------- | -------------- |
| POST   | `/tasks`      | Create task    |
| GET    | `/tasks`      | Get all tasks  |
| GET    | `/tasks/{id}` | Get task by id |
| PUT    | `/tasks/{id}` | Update task    |
| DELETE | `/tasks/{id}` | Delete task    |

---

## 🧪 API Documentation

Detailed API request examples are available in the API documentation directory.

- [cURL Examples](api-docs/curl-examples.md)
- Postman Collection: `api-docs/postman/task-manager-api.postman_collection.json`
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- Scalar API Reference: `http://localhost:8080/scalar`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

---

## ❤️ Spring Boot Actuator

### Health

```bash
curl http://localhost:8080/actuator/health
```

### Info

```bash
curl http://localhost:8080/actuator/info
```

---

## 📚 Documentation

Theoretical notes are available in the `docs/` directory.

Current topics:

* Container vs Virtual Machine
* CI/CD
* Docker Image vs Container
* Docker Registry
* Spring Boot
* Docker Volumes
* Docker Compose
* Jenkins Pipeline
* Kubernetes
* Monitoring & Observability

---

## 🗺 Roadmap

* [x] Spring Boot REST API
* [x] PostgreSQL
* [x] Docker
* [x] Docker Compose
* [x] CRUD Operations
* [x] Bean Validation
* [x] Global Exception Handling
* [x] Environment Variables
* [x] Spring Boot Actuator
* [x] API Documentation / Postman Collection
* [x] Swagger UI
* [x] Scalar API Reference
* [x] Unit Tests
* [x] Controller Tests
* [x] Repository Tests
* [x] Docker Compose Improvements
* [ ] Jenkins Pipeline
* [ ] Docker Registry
* [ ] Kubernetes
* [ ] Prometheus & Grafana
* [ ] Final Refactoring

---

## 📌 Project Status

🚧 **In Progress**

This repository is continuously updated while learning and implementing modern Java Backend Development and DevOps technologies step by step.
