package Restart.Hibernate.MappingTheory.model;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Auto-generate primary key
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL) // ✅ Cascade ensures Passport is saved with Person
    @JoinColumn(name = "passport_id", unique = true) // ✅ Foreign key column
    private Passport passport;

    // Constructors
    public Person() {}

    public Person(String name, int id) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Passport getPassport() { return passport; }
    public void setPassport(Passport passport) {
        this.passport = passport;
        if (passport != null) {
            passport.setPerson(this); // ✅ Ensure bidirectional linking
        }
    }
}
