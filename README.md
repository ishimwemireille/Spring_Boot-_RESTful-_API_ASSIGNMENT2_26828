# Bonus Question – User Profile API

This project implements a User Profile RESTful API using Spring Boot.

It includes advanced features such as:
- Custom API response wrapper
- Search functionality
- Filtering by country
- Filtering by age range
- Activate / Deactivate user functionality
- Full CRUD operations

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
3. Open terminal inside the project folder.
4. Run:

mvn spring-boot:run

5. The application runs at:

http://localhost:8080

---

## UserProfile Fields

Each user profile contains:

- userId (Long)
- username (String)
- email (String)
- fullName (String)
- age (int)
- country (String)
- bio (String)
- active (boolean)

---

## Custom API Response Structure

All responses are wrapped in a custom structure:

{
  "success": true,
  "message": "Description of result",
  "data": { ... }
}

This ensures consistent response formatting.

---

## API Endpoints

### 1. Get All Users
GET /api/users

---

### 2. Get User By ID
GET /api/users/{userId}

---

### 3. Search By Username
GET /api/users/search?username={username}

Example:
http://localhost:8080/api/users/search?username=mireille

---

### 4. Filter By Country
GET /api/users/country/{country}

Example:
http://localhost:8080/api/users/country/Rwanda

---

### 5. Filter By Age Range
GET /api/users/age-range?min={min}&max={max}

Example:
http://localhost:8080/api/users/age-range?min=20&max=30

---

### 6. Create New User
POST /api/users

Returns 201 Created.

---

### 7. Update User
PUT /api/users/{userId}

Returns 200 OK.

---

### 8. Activate User
PATCH /api/users/{userId}/activate

---

### 9. Deactivate User
PATCH /api/users/{userId}/deactivate

---

### 10. Delete User
DELETE /api/users/{userId}

---

## Status Codes Used

- 200 OK – Successful request
- 201 Created – User created
- 404 Not Found – User not found

---

## Testing

All endpoints were tested using Postman.
Screenshots were captured for:
- Retrieving users
- Searching by username
- Filtering by country
- Filtering by age range
- Creating user
- Updating user
- Activating and deactivating user
- Deleting user
