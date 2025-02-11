package Restart.Hibernate.MappingTheory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lapName;
    private String lapModel;
    private long lapPrice;
    private String brand;

    @ManyToOne
    @JoinColumn(name = "student_id") // Foreign key reference
    private Student student;

    public Laptop() {}

    public Laptop(String name, String model, String brand, long price, int id) {
        this.id = id;
        this.lapName = name;
        this.brand = brand;
        this.lapModel = model;
        this.lapPrice = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }

    public String getLapModel() {
        return lapModel;
    }

    public void setLapModel(String lapModel) {
        this.lapModel = lapModel;
    }

    public long getLapPrice() {
        return lapPrice;
    }

    public void setLapPrice(long lapPrice) {
        this.lapPrice = lapPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
