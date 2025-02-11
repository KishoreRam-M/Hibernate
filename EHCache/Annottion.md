# **Comprehensive Guide to `@Cache` and Related Annotations in Ehcache & Spring**  

## **📌 Introduction**
Caching is a crucial technique used to store frequently accessed data in memory, reducing database calls and improving application performance.  

Spring and Hibernate provide several **annotations** for implementing caching. This guide will break down:  

✔ **`@Cache` (Hibernate)** – Used for enabling Hibernate second-level cache.  
✔ **`@Cacheable` (Spring)** – Caches the result of a method.  
✔ **`@CachePut` (Spring)** – Updates the cache after method execution.  
✔ **`@CacheEvict` (Spring)** – Removes an entry from the cache.  
✔ **`@Caching` (Spring)** – Groups multiple cache operations.  

---

## **1️⃣ `@Cache` Annotation (Hibernate Ehcache)**
### **🔹 What is `@Cache` in Hibernate?**  
The `@Cache` annotation is used in Hibernate to **enable second-level caching** for an entity. It works with caching providers like **Ehcache, Redis, Infinispan, and Caffeine**.  

### **🔹 Example Usage**  
```java
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.io.Serializable;

@Entity
@Table(name = "employees")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "employeeCache")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;

    public Employee() {}

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getters and Setters
}
```
### **🔹 Explanation**
✔ `@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "employeeCache")`  
✔ **Enables Hibernate second-level caching for `Employee` entity**  
✔ `READ_WRITE` **prevents concurrent modification issues**  
✔ `region = "employeeCache"` **matches cache settings in `ehcache.xml`**  

---

### **🔹 Cache Concurrency Strategies**
| **Strategy** | **Description** |
|--------------|----------------|
| `READ_ONLY` | Best for static data (no updates). |
| `NONSTRICT_READ_WRITE` | Allows updates but does not ensure consistency. |
| `READ_WRITE` | Ensures safe concurrent access (recommended for most cases). |
| `TRANSACTIONAL` | Used for distributed caching with JTA transactions. |

---

## **2️⃣ `@Cacheable` (Spring Boot)**
### **🔹 What is `@Cacheable`?**  
The `@Cacheable` annotation **stores method return values in cache** so that future calls **retrieve from cache instead of executing the method again**.

### **🔹 Example Usage**  
```java
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Cacheable("employeeCache")
    public String getEmployee(int id) {
        System.out.println("Fetching from database...");
        return "Employee-" + id;
    }
}
```
✔ First call **executes method and stores the result in cache**  
✔ Second call **retrieves the result from cache (faster)**  

### **🔹 Real-World Analogy**
- **Without Cache:** Like ordering food **every time you get hungry**  
- **With Cache (`@Cacheable`)**: Like **keeping food in the fridge** for quick access  

---

## **3️⃣ `@CachePut` (Updating Cache)**
### **🔹 What is `@CachePut`?**  
The `@CachePut` annotation **updates the cache every time the method is executed**.  

### **🔹 Example Usage**  
```java
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @CachePut(value = "employeeCache", key = "#id")
    public String updateEmployee(int id, String name) {
        System.out.println("Updating employee in database...");
        return name;
    }
}
```
✔ **Forces a cache update** every time the method runs  
✔ Useful when **data updates frequently**  

---

## **4️⃣ `@CacheEvict` (Removing Data from Cache)**
### **🔹 What is `@CacheEvict`?**  
The `@CacheEvict` annotation **removes a specific entry or all entries from cache**.

### **🔹 Example Usage (Remove One Entry)**
```java
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @CacheEvict(value = "employeeCache", key = "#id")
    public void deleteEmployee(int id) {
        System.out.println("Removing employee from cache...");
    }
}
```
✔ Deletes **only the specified entry** from cache  

### **🔹 Example Usage (Clear Entire Cache)**
```java
@CacheEvict(value = "employeeCache", allEntries = true)
public void clearCache() {
    System.out.println("Cache cleared!");
}
```
✔ Deletes **all cached data**  

---

## **5️⃣ `@Caching` (Multiple Cache Operations)**
### **🔹 What is `@Caching`?**  
The `@Caching` annotation **combines multiple caching operations** in one method.

### **🔹 Example Usage**
```java
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Caching(
        put = { @CachePut(value = "employeeCache", key = "#id") },
        evict = { @CacheEvict(value = "employeeListCache", allEntries = true) }
    )
    public String updateEmployee(int id, String name) {
        System.out.println("Updating employee and clearing list cache...");
        return name;
    }
}
```
✔ **Updates individual employee cache**  
✔ **Clears employee list cache**  

---

## **6️⃣ Visual Summary of Spring Cache Annotations**  
| **Annotation** | **Purpose** | **Example Use Case** |
|--------------|------------|------------------|
| `@Cacheable` | Stores method results in cache | Fetching employee details |
| `@CachePut` | Updates the cache every time | Updating employee name |
| `@CacheEvict` | Removes an entry or clears cache | Deleting an employee |
| `@Caching` | Combines multiple cache operations | Updating and clearing cache |

---

## **7️⃣ Configuring Ehcache with Spring Boot**
Add `ehcache.xml` inside `src/main/resources/`:

```xml
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="http://www.ehcache.org/ehcache.xsd">

    <cache name="employeeCache"
           maxEntriesLocalHeap="1000"
           timeToLiveSeconds="600"
           overflowToDisk="true"
           diskPersistent="true"/>
</ehcache>
```
✔ **Limits cache size to 1000 entries**  
✔ **Entries expire after 10 minutes**  
✔ **Uses disk storage when memory is full**  

---

## **8️⃣ Enabling Caching in Spring Boot**
Add this annotation in your main class or config class:

```java
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
}
```
✔ **Enables caching in the entire application**  

---

## **9️⃣ Testing the Cache**
1️⃣ **Run your application**  
2️⃣ **Make API calls:**  
   ```
   http://localhost:8080/employees/1
   ```
   - First call **fetches from DB**  
   - Second call **fetches from cache (faster response)**  

3️⃣ **Update employee and check `@CachePut` behavior:**  
   ```
   http://localhost:8080/employees/update/1?name=JohnUpdated
   ```
   - Cache **updates with new value**  

4️⃣ **Delete employee and test `@CacheEvict`:**  
   ```
   http://localhost:8080/employees/delete/1
   ```
   - Cache entry **is removed**  

---

