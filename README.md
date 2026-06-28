# CRM - Customer Relationship Management System

A full-stack REST API backend for managing customer relationships, built with Spring Boot.

## 🛠 Tech Stack
- Java 17, Spring Boot 3.5.3
- Spring Security + JWT Authentication
- Spring Data JPA + Hibernate
- MySQL
- Swagger/OpenAPI
- Maven, Lombok

## 📦 Modules
| Entity | Endpoints |
|--------|-----------|
| Lead | GET, POST, PUT, DELETE |
| Company | GET, POST, PUT, DELETE |
| Contact | GET, POST, PUT, DELETE |
| Deal | GET, POST, PUT, DELETE |
| Task | GET, POST, PUT, DELETE |
| Note | GET, POST, PUT, DELETE |

## 🔐 Authentication
- JWT based authentication
- Register: `POST /api/auth/register`
- Login: `POST /api/auth/login`
- Use Bearer token in Authorization header for all APIs

## 🚀 How to Run Locally
1. Clone the repo
```bash
   git clone https://github.com/arpitgupta242005-dotcom/CRM.git
```
2. Create MySQL database
```sql
   CREATE DATABASE crm_db;
```
3. Update `application.properties`
```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
```
4. Run the app
```bash
   mvn spring-boot:run
```
5. Open Swagger UI
```
   http://localhost:8080/swagger-ui/index.html
```

## 📋 API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login and get JWT token |

### Leads
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/leads | Get all leads |
| GET | /api/leads/{id} | Get lead by ID |
| POST | /api/leads | Create lead |
| PUT | /api/leads/{id} | Update lead |
| DELETE | /api/leads/{id} | Delete lead |

### Companies
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/companies | Get all companies |
| GET | /api/companies/{id} | Get company by ID |
| POST | /api/companies | Create company |
| PUT | /api/companies/{id} | Update company |
| DELETE | /api/companies/{id} | Delete company |

## 🔒 Security
- Passwords encrypted with BCrypt
- Stateless JWT authentication
- Protected endpoints require Bearer token
