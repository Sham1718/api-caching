# API Caching Layer (Cache-Aside Pattern)

## Summary
A backend-focused Spring Boot project demonstrating the Cache-Aside caching pattern using an in-memory cache with TTL-based expiration for improved API performance.

---

# Overview

The API Caching Layer project is designed to demonstrate how backend caching mechanisms improve application performance by reducing repeated expensive data fetch operations.

This project implements:
- Cache-Aside caching strategy
- In-memory caching using `ConcurrentHashMap`
- TTL-based cache expiration
- Thread-safe cache operations
- Lazy loading and lazy eviction behavior

The application simulates a slow data source and showcases how cached responses significantly reduce response time for repeated API requests.

The primary focus of this project is understanding core backend caching logic rather than relying on framework abstractions or external caching systems.

---

# Problem Statement

Applications that repeatedly fetch the same expensive data suffer from:
- Increased response times
- Higher server load
- Poor scalability
- Unnecessary database/service calls

This project solves these problems by implementing:
- An efficient in-memory caching layer
- TTL-based automatic expiration
- Cache-Aside retrieval strategy

to improve backend API performance and reduce redundant operations.

---

# Tools and Tech

## Backend
- Java 17
- Spring Boot 3.2.x
- Spring Web

## Build Tool
- Maven

## Caching
- ConcurrentHashMap
- Cache-Aside Pattern
- TTL-based Expiration

---

# Methods

## Cache-Aside Pattern
The project follows the Cache-Aside caching strategy:

1. Client requests data
2. Application checks cache first
3. If cache hit:
   - Return cached response instantly
4. If cache miss:
   - Fetch data from slow source
   - Store result in cache
   - Return response to client

---

## Caching Behavior

- Caching Pattern: Cache-Aside
- Storage: In-memory (`ConcurrentHashMap`)
- TTL: 60 seconds
- Expiration Strategy: Lazy eviction on access
- Cache Key: Request path variable
- Data Source: Simulated slow service

---

## Thread-Safe Operations
The cache implementation uses:
- `ConcurrentHashMap`
- Safe concurrent access handling
- Thread-safe cache read/write operations

---

## Backend Design Decisions

- Spring Cache annotations are intentionally not used
- Redis is intentionally excluded
- Focus is on understanding core caching logic
- Minimal backend-focused architecture

---


# Key Insights

- Learned implementation of Cache-Aside strategy
- Understood TTL-based cache expiration
- Improved backend performance optimization knowledge
- Practiced thread-safe backend development
- Learned lazy loading and lazy eviction concepts
- Improved understanding of scalable backend architecture
- Understood real-world caching system design principles

---

# How to Run Project

## Clone Repository

```bash
git clone <your-repository-link>
```

---

## Open Project

Open the project in:
- IntelliJ IDEA
- VS Code
- Eclipse

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run Application

```bash
mvn spring-boot:run
```

---

## Default Server

```bash
http://localhost:8080
```

---

# API Endpoint

## Fetch Cached Data

```http
GET /data/{key}
```

### Example

```http
GET /data/test
```

---

# How to Test (Postman)

## Expected Behavior

### First Request
- Takes approximately 3 seconds
- Simulates slow data source fetch

### Repeated Requests
- Instant response
- Data served from cache

### After 60 Seconds
- Cache expires
- Data reloads from slow source again

---


# Author and Contact

## Author
Shyam

## Contact
- GitHub: https://github.com/Sham1718
- Portfolio: https://shyam-neon.vercel.app/

---

⭐ If you find this project useful, consider giving it a star.
