# Task Manager API - cURL Examples

Base URL

```text
http://localhost:8080
```

---

# Create Task

```bash
curl -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{
"title":"Docker Compose öğren",
"description":"Spring Boot and PostgreSQL are working together."
}'
```

---

# Get All Tasks

```bash
curl http://localhost:8080/tasks
```

---

# Get Task By Id

```bash
curl http://localhost:8080/tasks/1
```

---

# Update Task

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

# Delete Task

```bash
curl -i -X DELETE http://localhost:8080/tasks/1
```

---

# Validation Example

```bash
curl -i -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{
"title":"",
"description":"Validation test"
}'
```

Expected Response

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

# Task Not Found Example

```bash
curl -i http://localhost:8080/tasks/999
```

Expected Response

```json
{
  "timestamp": "...",
  "status": 404,
  "error": "Not Found",
  "message": "Task with id 999 not found",
  "fieldErrors": null
}
```

---

# Spring Boot Actuator

## Health

```bash
curl http://localhost:8080/actuator/health
```

---

## Info

```bash
curl http://localhost:8080/actuator/info
```

---

# OpenAPI

## OpenAPI JSON

```text
http://localhost:8080/v3/api-docs
```

## Swagger UI

```text
http://localhost:8080/swagger-ui/index.html
```
