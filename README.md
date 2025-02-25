# 2-Microservices-App

### USER Service: 
Handles user registration, authentication, and profile management;
JWT for authentication;
Connects h2db for testing; 
REST endpoints:
- POST /users/register (register user)
- POST /users/login (authenticate and return JWT)
- GET /users/{id} (fetch user details, secured by JWT)

### PRODUCT Service
Manages product information;
Requires JWT authentication for access;
Connects to H2DB for testing;
REST endpoints:
- GET /products/{id} (fetch product details) 
- POST /products (add a new product, secured by JWT)

The Product Service requires a valid JWT from User Service for access (REST API).

### Tech Stack
- Backend: Spring Boot
- Database: H2DB
- Authentication: JWT
- Deployment: Firebase

### How It Works (Step-by-Step Flow)

1️⃣ User Registration & Login
- A user registers via POST /users/register with a username and password.
- Passwords are hashed and stored in the H2 database.
- The user logs in via POST /users/login with valid credentials.
- If successful, a JWT token is generated and returned.

2️⃣ Using JWT to Access Product Service
- The user includes the JWT token in the Authorization header (Bearer <JWT>).
- Product Service verifies the token using the JWT secret key.
- If valid, the user can:
- Fetch a product via GET /products/{id}.
- Add a new product via POST /products (secured).
