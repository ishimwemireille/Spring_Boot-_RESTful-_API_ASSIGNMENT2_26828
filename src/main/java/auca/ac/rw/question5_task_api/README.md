# Question 5 – Task Management API

This project implements a simple Task / To-Do List RESTful API using Spring Boot.

It allows users to create, retrieve, update, filter, complete, and delete tasks.

---

## Author

Name: ISHIMWE Mireille  
Student ID: 26828  

---

## Technologies Used

- Java 21
- Spring Boot
- Maven
- Spring Web
- Postman (for API testing)

---

## How to Run the Application

1. Open the project in VS Code.
2. Make sure Java 21 is installed.
3. Open the terminal inside the project folder.
4. Run:

mvn spring-boot:run

5. The application runs at:

http://localhost:8080

---

## Task Fields

Each Task contains:

- taskId (Long)
- title (String)
- description (String)
- completed (boolean)
- priority (String) – LOW, MEDIUM, HIGH
- dueDate (String) – format YYYY-MM-DD

---

## API Endpoints

### 1. Get All Tasks

GET /api/tasks

Example:
http://localhost:8080/api/tasks

---

### 2. Get Task By ID

GET /api/tasks/{taskId}

Example:
http://localhost:8080/api/tasks/1

---

### 3. Get Tasks By Completion Status

GET /api/tasks/status?completed=true

Example:
http://localhost:8080/api/tasks/status?completed=false

---

### 4. Get Tasks By Priority

GET /api/tasks/priority/{priority}

Example:
http://localhost:8080/api/tasks/priority/HIGH

---

### 5. Create New Task

POST /api/tasks

Example JSON Body:

{
  "taskId": 5,
  "title": "Read Java Notes",
  "description": "Review OOP concepts",
  "completed": false,
  "priority": "MEDIUM",
  "dueDate": "2026-02-22"
}

Returns 201 Created.

---

### 6. Update Task

PUT /api/tasks/{taskId}

Returns 200 OK.

---

### 7. Mark Task As Completed

PATCH /api/tasks/{taskId}/complete

Returns 200 OK.

---

### 8. Delete Task

DELETE /api/tasks/{taskId}

Returns 204 No Content.

---

## Status Codes Used

- 200 OK – Successful request
- 201 Created – Task created
- 204 No Content – Task deleted
- 404 Not Found – Task not found

---

## Testing

All endpoints were tested using Postman.
Screenshots were captured for:
- Retrieving tasks
- Filtering by status
- Filtering by priority
- Creating task
- Updating task
- Marking as completed
- Deleting task
