# SIIMP (Simple Implementation) Series with Java Spring by Viody Alfaridzi

The goal is to create an overview of how the Tools/Kit/Env works.

I Implemented common functions, such listed below :

✅ User Registration & Login (JWT Auth)  
✅ Full CRUD operations for Notes  
✅ Pagination and Keyword Search  
✅ User-based note access protection  
✅ Environment-based configuration with `.env`  
✅ MySQL or H2 database support

---

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Security + JPA
- MySQL / H2 Database
- JWT (JSON Web Token)
- Lombok
- java-dotenv (for environment variables)

---

## How to run

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/notes-api-springboot.git
cd notes-api-springboot
```
### 2. Create a .env File
Just set it up like the .env.example !?

### 3. Run the App
```bash
./mvnw spring-boot:run
```