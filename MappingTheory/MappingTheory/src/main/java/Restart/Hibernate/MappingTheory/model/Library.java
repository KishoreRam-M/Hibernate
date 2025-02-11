package Restart.Hibernate.MappingTheory.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private int id;

    private String book;
    private boolean valid;

    @ManyToMany(mappedBy = "libraries") // Corrected field name
    private List<LibStudent> students;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public List<LibStudent> getStudents() {
        return students;
    }

    public void setStudents(List<LibStudent> students) {
        this.students = students;
    }
}
