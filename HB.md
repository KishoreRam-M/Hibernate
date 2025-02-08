
# **Understanding ORM & Hibernate**  

## **1. What is ORM (Object-Relational Mapping)?**
### **Definition**  
**ORM (Object-Relational Mapping)** is a technique that allows developers to interact with a database using **objects** instead of writing SQL queries directly. It acts as a bridge between a relational database (like PostgreSQL) and object-oriented programming (like Java).  

### **Why is ORM needed?**
- **Problem:** SQL works with tables and rows, but Java works with objects. Converting objects into SQL manually is tedious.  
- **Solution:** ORM helps automatically map objects to database tables, reducing boilerplate code and making database interaction easier.  

### **Real-World Analogy**  
💡 Think of ORM as **Google Translate** for databases.  
- You (Java) speak **Objects**  
- The database (SQL) speaks **Tables & Rows**  
- ORM **translates** between them automatically.  

---

## **2. Why Hibernate?**
Hibernate is one of the most popular ORM frameworks for Java.  

### **Advantages of Hibernate over JDBC (Traditional SQL Approach)**  
| Feature | JDBC (Without ORM) | Hibernate (With ORM) |
|---------|--------------------|----------------------|
| Querying Data | Write raw SQL manually | Uses objects, automatically generates SQL |
| Code Maintenance | More repetitive SQL code | Less code, easy to maintain |
| Database Independence | SQL may need modification for different databases | Works with multiple databases automatically |
| Caching | No built-in caching | Has powerful caching mechanisms |
| Object Management | Manual mapping between Java objects and database rows | Automatically maps Java objects to database |

✅ **Key Benefits of Hibernate**:  
- **Reduces code complexity**  
- **Eliminates database-specific SQL dependency**  
- **Supports caching for performance improvement**  
- **Manages relationships between objects easily**  

---

## **3. Entity Lifecycle in Hibernate**  
Hibernate manages Java objects in different states. These states define how an object interacts with the database.  

### **Four Lifecycle States**  
1. **Transient State**  
   - Object is created using `new` but **not associated with Hibernate**.  
   - It **does not exist in the database** yet.  
   - Example:
     ```java
     User user = new User(); // Transient state (Not saved in DB)
     ```
  
2. **Persistent State**  
   - Object is saved into the database using Hibernate’s `save()` or `persist()`.  
   - Hibernate **tracks changes** to this object.  
   - Example:
     ```java
     session.save(user); // Now user is in Persistent state
     ```
  
3. **Detached State**  
   - Object was once **Persistent**, but now Hibernate is **not tracking** it.  
   - Occurs when a Hibernate session is closed.  
   - Example:
     ```java
     session.close(); // User object becomes Detached
     ```
  
4. **Removed State**  
   - Object is marked for deletion from the database.  
   - Example:
     ```java
     session.delete(user); // User is now in Removed state
     ```

### **Visual Representation of Hibernate Entity Lifecycle**
```
      +----------------------+
      |  Transient State     |  (new User();)
      +----------+-----------+
                 |
                 v (session.save(user);)
      +----------------------+
      |  Persistent State    |
      +----------+-----------+
        |                   |
        | session.close();   | session.delete(user);
        v                   v
+----------------+   +----------------+
| Detached State |   | Removed State  |
+----------------+   +----------------+
```

**Key Takeaway:** Hibernate automatically tracks objects in the **Persistent state**, meaning any changes to them are automatically updated in the database.

---

## **4. Session & SessionFactory – Managing Database Connections**  
### **What is a Hibernate Session?**
- A **Hibernate Session** is a single-threaded object that acts as a bridge between the application and the database.  
- It is used to **store, retrieve, update, and delete** objects.  

### **What is SessionFactory?**
- **SessionFactory** is responsible for **creating Hibernate Sessions**.  
- It is a **singleton** and is created only once during application startup.  
- **Sessions are created from SessionFactory** whenever needed.  

### **Example of Managing Sessions in Hibernate**
```java
SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
Session session = factory.openSession(); // Creating session
session.beginTransaction();

User user = new User(); // Creating user (Transient state)
session.save(user); // Now Persistent state

session.getTransaction().commit();
session.close(); // Now user is in Detached state
```

### **Best Practices for Managing Sessions**
✅ Always close the session after use (`session.close()`).  
✅ Use `SessionFactory` as a singleton to avoid multiple unnecessary connections.  
✅ Use **transactions** (`session.beginTransaction()`) to ensure consistency.  

---

## **5. Primary Annotations in Hibernate**
Hibernate uses **annotations** to map Java classes to database tables.  

| Annotation | Description | Example |
|------------|------------|---------|
| `@Entity` | Marks a class as a database entity | `@Entity class User { }` |
| `@Table(name="users")` | Maps a class to a specific table | `@Table(name="users")` |
| `@Id` | Specifies the primary key | `@Id private int id;` |
| `@GeneratedValue(strategy = GenerationType.IDENTITY)` | Auto-generates primary key values | `@GeneratedValue(strategy = GenerationType.IDENTITY)` |
| `@Column(name="user_name")` | Maps a field to a specific column | `@Column(name="user_name")` |

### **Example of Entity Class**
```java
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String name;

    // Getters and Setters
}
```

---

## **6. JPA vs Hibernate – Differences and Usage**
### **What is JPA?**
- **JPA (Java Persistence API)** is a specification (a set of guidelines) for ORM in Java.
- Hibernate is an **implementation** of JPA.

### **Differences Between JPA & Hibernate**
| Feature | JPA | Hibernate |
|---------|-----|----------|
| Type | Specification | Implementation of JPA |
| Flexibility | Works with different providers (EclipseLink, Hibernate) | Only Hibernate |
| Complexity | Simplifies ORM usage | Provides more features |
| Query Language | JPQL (Java Persistence Query Language) | HQL (Hibernate Query Language) |

### **Example of JPA vs Hibernate**
Using **JPA** (Generic ORM Framework)
```java
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
}
```

Using **Hibernate** (Specific ORM Framework)
```java
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}

