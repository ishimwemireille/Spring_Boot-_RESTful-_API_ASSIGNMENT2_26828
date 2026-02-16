# Question 1 – Library Book Management API

This project implements a RESTful API for managing library books using Spring Boot.

## Author 
ISHIMWE Mireille
ID: 26828

## Technologies Used

- Java 21
- Spring Boot
- Maven
- Spring Web

---

## How to Run the Application

1. Open the project in VS Code.
2. Make sure Java 21 is installed.
3. Open terminal inside the project folder.
4. Run:

mvn spring-boot:run

5. The application will start on:

http://localhost:8080

---

## API Endpoints

### 1. Get All Books

GET /api/books

Example:
http://localhost:8080/api/books

Returns a list of all books.

---

### 2. Get Book By ID

GET /api/books/{id}

Example:
http://localhost:8080/api/books/1

Returns a specific book by ID.

---

### 3. Search Book By Title

GET /api/books/search?title={title}

Example:
http://localhost:8080/api/books/search?title=clean

Returns books that contain the given title.

---

### 4. Add New Book

POST /api/books

Example Body (JSON):

{
  "id": 4,
  "title": "Our Lady of the Nile",
  "author": "Scholastique Mukasonga",
  "isbn": "9781939810533",
  "publicationYear": 2012
}

Returns status 201 Created.

---

### 5. Delete Book

DELETE /api/books/{id}

Example:
DELETE http://localhost:8080/api/books/4

Returns status 204 No Content.

---

## Status Codes Used

- 200 OK – Successful request
- 201 Created – Book created
- 204 No Content – Book deleted
- 404 Not Found – Book not found

---

## Testing

All endpoints were tested using Postman to ensure they work correctly according to the assignment requirements.
