# Question 2 – Student Registration API

This project implements a RESTful API for managing student registration and student information using Spring Boot.

## Technologies Used

- Java 21
- Spring Boot
- Maven
- Spring Web

---

## How to Run the Application

1. Open the project in VS Code.
2. Make sure Java 21 is installed.
3. Open the terminal inside the project folder.
4. Run the following command:

mvn spring-boot:run

5. The application will start on:

http://localhost:8080

---

## API Endpoints

### 1. Get All Students

GET /api/students

Example:
http://localhost:8080/api/students

Returns a list of all students.

---

### 2. Get Student By ID

GET /api/students/{studentId}

Example:
http://localhost:8080/api/students/1

Returns a specific student by ID.

---

### 3. Get Students By Major

GET /api/students/major/{major}

Example:
http://localhost:8080/api/students/major/Computer Science

Returns all students in a specific major.

---

### 4. Filter Students By GPA

GET /api/students/filter?gpa={minGpa}

Example:
http://localhost:8080/api/students/filter?gpa=3.5

Returns students whose GPA is greater than or equal to the specified value.

---

### 5. Register New Student

POST /api/students

Example Request Body (JSON):

{
  "studentId": 6,
  "firstName": "Kevin",
  "lastName": "Nshuti",
  "email": "Kevin@gmail.com",
  "major": "Computer Science",
  "gpa": 2.7
}

Creates a new student and returns status 201 Created.

---

### 6. Update Student Information

PUT /api/students/{studentId}

Example:
PUT http://localhost:8080/api/students/6

Request Body (JSON):

{
  "studentId": 6,
  "firstName": "Samuel",
  "lastName": "Karangwa",
  "email": "samuel.k@example.com",
  "major": "Software Engineering",
  "gpa": 3.7
}

Updates the student information and returns status 200 OK.

---

## Status Codes Used

- 200 OK – Successful request
- 201 Created – New student created
- 404 Not Found – Student not found

---

## Testing

All endpoints were tested using Postman to ensure they work correctly according to the assignment requirements.
