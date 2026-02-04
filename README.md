API Caching Layer (Cache-Aside Pattern)

A backend-focused API caching layer built with Spring Boot, demonstrating the Cache-Aside pattern using an in-memory data store with TTL support.  
This project shows how caching improves performance by avoiding repeated expensive data fetches.

------------------------------------------------------------

FEATURES

- Cache-Aside caching pattern
- In-memory cache using ConcurrentHashMap
- TTL-based cache expiration
- Thread-safe cache operations
- Lazy loading on cache miss
- Clear performance difference between cached and non-cached requests
- Backend-only, minimal and focused design

------------------------------------------------------------

TECH STACK

- Java 17
- Spring Boot 3.2.x
- Spring Web
- Maven

------------------------------------------------------------

PROJECT STRUCTURE

src/main/java/com/api_cache

config  
- CacheConfig.java  

cache  
- CacheEntry.java  
- CacheStore.java  
- CacheService.java  

service  
- DataService.java  

controller  
- DataController.java  

ApiCacheApplication.java

------------------------------------------------------------

CACHING BEHAVIOR

- Caching Pattern: Cache-Aside
- Storage: In-memory (ConcurrentHashMap)
- TTL: 60 seconds
- Expiration Strategy: Lazy eviction on access
- Cache Key: Request path variable
- Data Source: Simulated slow service

------------------------------------------------------------

HOW IT WORKS

1. Client requests data using a key
2. Application checks cache first
3. If cache hit and not expired:
   - Data is returned immediately
4. If cache miss or expired:
   - Data is loaded from a slow source
   - Result is stored in cache with TTL
   - Data is returned to client
5. Once TTL expires, the next request reloads data

------------------------------------------------------------

HOW TO TEST (POSTMAN)

Endpoint:
GET /data/{key}

Example:
GET /data/test

Expected Behavior:
- First request:
  - Takes ~3 seconds (simulated slow source)
- Subsequent requests with same key:
  - Instant response (cached)
- After 60 seconds:
  - Cache expires
  - Next request is slow again

------------------------------------------------------------

DESIGN NOTES

- Spring Cache annotations are intentionally not used
- Redis is intentionally not included
- The goal is to demonstrate core caching logic, not framework abstractions
- In real-world systems, Redis or Memcached would replace the in-memory store

------------------------------------------------------------

POSSIBLE ENHANCEMENTS

- Redis-based distributed cache
- Per-key or per-endpoint TTL configuration
- Cache metrics and hit/miss ratio
- Write-through or write-behind strategies
- Cache eviction policies (LRU, LFU)

------------------------------------------------------------

AUTHOR

Shyam  
Backend / Full Stack Developer  
Focused on backend systems, performance, and clean architecture

------------------------------------------------------------

If you find this project useful, consider giving it a star ⭐
