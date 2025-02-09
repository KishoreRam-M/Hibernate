package Restart.Pratice_1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lapId;
    private String name;
    private int price;

    @OneToOne
    @JoinColumn(name = "student_id", unique = true) // Foreign Key Column
    private Student student;

    // Constructors
    public Laptop() {}

    public Laptop(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getLapId() { return lapId; }
    public void setLapId(int lapId) { this.lapId = lapId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}
