# 📘 SIIMP (Simple Implementation) Series with Java Spring
by [Viody Alfaridzi](https://github.com/viodyalfaridzi)

This project is part of the **SIIMP Series** — aiming to give a practical, real-world overview of how tools, kits, and environments work together in Java Spring Boot projects.

---

## ✅ Features Implemented

- 🔐 User Registration & Login (JWT Auth)
- 📝 Full CRUD operations for Notes
- 🔍 Pagination and Keyword Search
- 🛡️ Role-based Access (User vs Admin)
- 👤 User Profile Management (bio & profile picture)
- 📂 File Upload & Static File Access
- 🔧 Environment-based configuration with `.env`
- 💾 MySQL or H2 Database Support

---

## 🚀 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security + JPA
- MySQL / H2
- JWT (JSON Web Token)
- Lombok
- `java-dotenv` (env variable loader)

---

## How to run

### 1. Clone the Repository

```bash
git clone https://<this-remote-url>.git
cd notes-api-springboot
```
### 2. Create a .env File
Just set it up like the .env.example !?
If wanna use PostgreSql, Switch the value of the db from env to jdbc:postgresql://<db-connection> and uncomment the .properties for postgre

### 3. Run the App
```bash
./mvnw spring-boot:run
```