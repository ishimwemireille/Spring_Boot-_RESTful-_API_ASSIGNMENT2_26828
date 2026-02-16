# Question 3 – Restaurant Menu API

This project implements a RESTful API for managing a restaurant menu using Spring Boot.

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

### 1. Get All Menu Items
GET /api/menu

Example:
http://localhost:8080/api/menu

---

### 2. Get Menu Item By ID
GET /api/menu/{id}

Example:
http://localhost:8080/api/menu/1

---

### 3. Get Menu Items By Category
GET /api/menu/category/{category}

Examples:
http://localhost:8080/api/menu/category/Main Course  
http://localhost:8080/api/menu/category/Dessert  

---

### 4. Get Available Items
GET /api/menu/available?available=true

Example:
http://localhost:8080/api/menu/available?available=true

---

### 5. Search Menu Item By Name
GET /api/menu/search?name={name}

Example:
http://localhost:8080/api/menu/search?name=coffee

---

### 6. Add New Menu Item
POST /api/menu

Example Body (JSON):

{
  "id": 9,
  "name": "Beef Burger",
  "description": "Grilled beef burger with cheese",
  "price": 6.5,
  "category": "Main Course",
  "available": true
}

Returns status 201 Created.

---

### 7. Toggle Item Availability
PUT /api/menu/{id}/availability

Example:
PUT http://localhost:8080/api/menu/6/availability

Returns status 200 OK.

---

### 8. Delete Menu Item
DELETE /api/menu/{id}

Example:
DELETE http://localhost:8080/api/menu/8

Returns status 204 No Content.

---

## Status Codes Used

- 200 OK – Successful request
- 201 Created – New item created
- 204 No Content – Item deleted
- 404 Not Found – Item not found

---

## Testing

All endpoints were tested using Postman to ensure correct functionality according to assignment requirements.
