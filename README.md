# Question 4 – E-Commerce Product API

This project implements a RESTful API for managing products in an e-commerce system using Spring Boot.

The API supports filtering, searching, pagination, stock updates, and full CRUD operations.

---

## Technologies Used

- Java 21
- Spring Boot
- Maven
- Spring Web
- Postman (for testing)

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

## Product Fields

Each product contains:

- productId (Long)
- name (String)
- description (String)
- price (Double)
- category (String)
- stockQuantity (int)
- brand (String)

---

## API Endpoints

### 1. Get All Products

GET /api/products

Example:
http://localhost:8080/api/products

---

### 2. Pagination

GET /api/products?page=0&limit=3

Returns a subset of products based on page and limit.

---

### 3. Get Product By ID

GET /api/products/{productId}

Example:
http://localhost:8080/api/products/1

---

### 4. Filter By Category

GET /api/products/category/{category}

Example:
http://localhost:8080/api/products/category/Electronics

---

### 5. Filter By Brand

GET /api/products/brand/{brand}

Example:
http://localhost:8080/api/products/brand/IKEA

---

### 6. Search By Keyword

GET /api/products/search?keyword={keyword}

Example:
http://localhost:8080/api/products/search?keyword=iphone

---

### 7. Filter By Price Range

GET /api/products/price-range?min={min}&max={max}

Example:
http://localhost:8080/api/products/price-range?min=100&max=500

---

### 8. Get Products In Stock

GET /api/products/in-stock

Returns products with stockQuantity greater than 0.

---

### 9. Add New Product

POST /api/products

Example Body (JSON):

{
  "productId": 11,
  "name": "MacBook Air",
  "description": "Apple lightweight laptop",
  "price": 1400.0,
  "category": "Electronics",
  "stockQuantity": 8,
  "brand": "Apple"
}

Returns status 201 Created.

---

### 10. Update Product

PUT /api/products/{productId}

Example:
PUT http://localhost:8080/api/products/11

Returns status 200 OK.

---

### 11. Update Stock Only

PATCH /api/products/{productId}/stock?quantity={quantity}

Example:
PATCH http://localhost:8080/api/products/11/stock?quantity=20

Returns status 200 OK.

---

### 12. Delete Product

DELETE /api/products/{productId}

Example:
DELETE http://localhost:8080/api/products/11

Returns status 204 No Content.

---

## Status Codes Used

- 200 OK – Successful request
- 201 Created – Product created
- 204 No Content – Product deleted
- 404 Not Found – Product not found

---

## Testing

All endpoints were tested using Postman.  
Screenshots were captured for each major operation including filtering, searching, pagination, stock update, and CRUD operations.
Author: ISHIMWE Mireille
Id: 26828
