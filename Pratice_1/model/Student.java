package Restart.Pratice_1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Laptop laptop;

    // Constructors
    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Laptop getLaptop() { return laptop; }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
        laptop.setStudent(this); // 🔥 Ensure bidirectional linking
    }
}
