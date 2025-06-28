## ✅ FULL LIST: Hibernate + Database Concepts in Spring Boot (Beginner → Advanced)

### 🔹 1. **Core Hibernate ORM**

* `@Entity`, `@Table`, `@Column`, `@Id`, `@GeneratedValue`
* Mapping Java objects to DB tables
* HQL (Hibernate Query Language)
* Named Queries
* Criteria API

---

### 🔹 2. **Spring Data JPA Integration**

* `JpaRepository`, `CrudRepository`, `PagingAndSortingRepository`
* Derived query methods: `findByEmailAndStatus()`
* `@Query`, native queries
* EntityManager & JPQL
* DTO projections
* Specifications API

---

### 🔹 3. **Entity Relationships**

* `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`
* `@JoinColumn`, `@JoinTable`
* `mappedBy`, cascading, orphan removal

---

### 🔹 4. **Fetching Strategies**

* `FetchType.LAZY` vs `FetchType.EAGER`
* N+1 problem
* Fetch joins
* Batch fetching

---

### 🔹 5. **Transaction Management**

* `@Transactional`, propagation, rollback
* Read-only transactions
* Programmatic vs declarative transactions

---

### 🔹 6. **Connection Pooling** ✅

* **What is it?** Reusing DB connections to reduce overhead.
* **HikariCP** – Default connection pool in Spring Boot (fastest).
* Other options: **C3P0**, **Apache DBCP**
* Key configs:

  ```properties
  spring.datasource.hikari.maximum-pool-size=10
  spring.datasource.hikari.idle-timeout=30000
  spring.datasource.hikari.pool-name=HikariPool
  ```

---

### 🔹 7. **Caching in Hibernate** ✅

* First-level (default)
* Second-level with:

  * **Ehcache**
  * **Redis**
  * **Caffeine**
* Query cache
* Annotations: `@Cacheable`, `@EnableCaching`

---

### 🔹 8. **Schema Management**

* Hibernate DDL: `spring.jpa.hibernate.ddl-auto=update/create/validate`
* **Liquibase** / **Flyway** for versioned schema migrations

---

### 🔹 9. **Validation**

* Bean Validation API (JSR 380)
* `@NotNull`, `@Email`, `@Size`, etc.
* `@Valid` and `@Validated` in controllers
* Custom constraints

---

### 🔹 10. **Database Configuration**

* DB URLs, drivers, dialects
* Time zones, charsets
* Profiles (`dev`, `prod`) using `application-dev.yml`

---

### 🔹 11. **Pagination & Sorting**

* `Pageable`, `Sort`, `PageRequest`
* `findAll(Pageable pageable)`
* Custom pagination queries

---

### 🔹 12. **Auditing**

* `@CreatedDate`, `@LastModifiedDate`
* `@EnableJpaAuditing`
* Useful for logging & entity lifecycle

---

### 🔹 13. **Soft Deletes**

* `@SQLDelete`, `@Where`
* Logical deletion using `deleted=true`

---

### 🔹 14. **Performance Tuning**

* Indexes and constraints
* Batch inserts/updates (`hibernate.jdbc.batch_size`)
* SQL logging:

  ```properties
  spring.jpa.show-sql=true
  spring.jpa.properties.hibernate.format_sql=true
  logging.level.org.hibernate.SQL=DEBUG
  ```

---

### 🔹 15. **Multitenancy (Advanced)**

* Shared DB with tenant\_id
* Separate DB per tenant
* Hibernate + Spring Boot configuration

---

### 🔹 16. **Exception Handling**

* `@ControllerAdvice`, `@ExceptionHandler`
* Catching `DataIntegrityViolationException`, `LazyInitializationException`, etc.

---

### 🔹 17. **Security + Best Practices**

* DTOs for data exposure
* Limit eager fetching
* Use `@Transactional(readOnly=true)` for read queries
* Secure DB credentials using environment variables or Vault

---

### 🔹 18. **Database Testing**

* H2 in-memory database
* `@DataJpaTest`, Testcontainers
* Flyway migrations in test DBs

---
