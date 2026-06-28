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
* `.env.example`
* CRUD REST API
* Bean Validation
* Global Exception Handling
* Standard Error Response
* Spring Boot Actuator

    * `/actuator/health`
    * `/actuator/info`

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

## 🧪 Example Requests

### Create Task

```bash
curl -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{
"title":"Docker Compose öğren",
"description":"Spring Boot and PostgreSQL are working together."
}'
```

---

### Get All Tasks

```bash
curl http://localhost:8080/tasks
```

---

### Get Task By Id

```bash
curl http://localhost:8080/tasks/1
```

---

### Update Task

```bash
curl -X PUT http://localhost:8080/tasks/1 \
-H "Content-Type: application/json" \
-d '{
"title":"Docker Compose Completed",
"description":"Docker environment is ready.",
"completed":true
}'
```

---

### Delete Task

```bash
curl -X DELETE http://localhost:8080/tasks/1
```

---

## ❌ Validation Example

```bash
curl -i -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{
"title":"",
"description":"Validation test"
}'
```

Example response

```json
{
  "timestamp": "...",
  "status": 400,
  "error": "Bad Request",
  "message": "Validation failed",
  "fieldErrors": {
    "title": "Title is required"
  }
}
```

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
* [ ] Docker Compose Improvements
* [ ] API Documentation / Postman Collection
* [ ] Jenkins Pipeline
* [ ] Docker Registry
* [ ] Kubernetes
* [ ] Prometheus & Grafana
* [ ] Final Refactoring

---

## 📌 Project Status

🚧 **In Progress**

This repository is continuously updated while learning and implementing modern Java Backend Development and DevOps technologies step by step.
