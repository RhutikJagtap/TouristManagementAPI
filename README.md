# Tourist Management REST API

A simple Spring Boot RESTful API for managing tourist information.  
Developed by **Rhutik Jagtap**.

## 🚀 Features
- Register a new tourist  
- Fetch tourist details by ID  
- Retrieve all tourists  
- Update full tourist information  
- Update only the tourist budget (partial update)  
- Delete a tourist by ID  

## 🛠️ Technologies Used
- Java 17+
- Spring Boot
- Spring Data JPA / Hibernate
- RESTful APIs
- MySQL (or any relational database)

## 📍 API Endpoints
----------------------------------------------------------------------------------
| Method | Endpoint                                   | Description              |
|--------|--------------------------------------------|--------------------------|
| POST   | `/register`                                | Register a new tourist   |
| GET    | `/getTourist/{touristId}`                  | Get tourist by ID        |
| GET    | `/getAllTourists`                          | Get all tourists         |
| PUT    | `/updateTourist`                           | Update full tourist info |
| PATCH  | `/updateTouristBudget/{touristId}/{budget}`| Update only budget       |
| DELETE | `/deleteTourist/{touristId}`               | Delete tourist by ID     |
----------------------------------------------------------------------------------

## ⚙️ Example URLs
POST http://localhost:8080/TouristManagementAPI/register
GET http://localhost:8080/TouristManagementAPI/getTourist/1
GET http://localhost:8080/TouristManagementAPI/getAllTourists
PUT http://localhost:8080/TouristManagementAPI/updateTourist
PATCH http://localhost:8080/TouristManagementAPI/updateTouristBudget/1/50000
DELETE http://localhost:8080/TouristManagementAPI/deleteTourist/1

