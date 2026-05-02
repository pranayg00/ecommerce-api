# 🛒 E-Commerce REST API

A production-grade E-Commerce REST API built with Java 17, Spring Boot 3, Apache Kafka, Redis, and Docker. Designed with clean architecture and enterprise patterns.

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-6DB33F?logo=spring)
![Kafka](https://img.shields.io/badge/Apache_Kafka-7.4-231F20?logo=apache-kafka)
![Redis](https://img.shields.io/badge/Redis-7-DC382D?logo=redis)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?logo=docker)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-4169E1?logo=postgresql)

## ✨ Features

- 🔐 JWT Authentication with Spring Security
- 🛍️ Product catalog with Redis caching
- 📦 Order management with stock validation
- 📨 Event-driven architecture with Apache Kafka
- 🐳 Full Docker + Docker Compose setup
- ✅ Global exception handling
- 🔒 Role-based access control (USER/ADMIN)

## 🏗️ Architecture

├── controller/     # REST API endpoints
├── service/        # Business logic layer
├── repository/     # JPA data access layer
├── model/          # JPA entities
├── dto/            # Request/Response objects
├── security/       # JWT filter + token service
├── kafka/          # Event producer/consumer
├── config/         # Security, Redis, Kafka config
└── exception/      # Global exception handler

## 🛠 Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot 3.5
- **Security:** Spring Security + JWT
- **Database:** PostgreSQL 15 + Spring Data JPA
- **Caching:** Redis 7
- **Messaging:** Apache Kafka
- **Containerization:** Docker + Docker Compose
- **Build Tool:** Maven

## 📡 API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login and get JWT token |

### Products
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /api/products | Get all products (cached) |
| GET | /api/products/{id} | Get product by ID |
| GET | /api/products/category/{cat} | Filter by category |
| GET | /api/products/search?name= | Search products |
| POST | /api/products | Create product (ADMIN) |
| PUT | /api/products/{id} | Update product (ADMIN) |
| DELETE | /api/products/{id} | Delete product (ADMIN) |

### Orders
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/orders | Create new order |
| GET | /api/orders | Get user's orders |
| GET | /api/orders/{id} | Get order by ID |
| PUT | /api/orders/{id}/status | Update status (ADMIN) |

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Docker & Docker Compose

### Run with Docker

```bash
git clone https://github.com/pranayg00/ecommerce-api
cd ecommerce-api
docker-compose up --build
```

API will be available at `http://localhost:8080`

### Run Locally

```bash
# Start infrastructure
docker-compose up postgres redis kafka -d

# Run the app
./mvnw spring-boot:run
```

## 🔑 Environment Variables

```env
DATABASE_URL=jdbc:postgresql://localhost:5432/ecommerce
DB_USERNAME=postgres
DB_PASSWORD=postgres
JWT_SECRET=your-secret-key
REDIS_HOST=localhost
REDIS_PORT=6379
KAFKA_SERVERS=localhost:9092
```

## 📌 Roadmap

- [ ] GraphQL API layer
- [ ] Payment integration
- [ ] Email notifications
- [ ] Kubernetes deployment manifests
- [ ] Unit and integration tests
- [ ] API documentation with Swagger

## 📄 License

MIT License — feel free to use this project as a reference.