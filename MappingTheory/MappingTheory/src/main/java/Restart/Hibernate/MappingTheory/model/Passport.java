package Restart.Hibernate.MappingTheory.model;

import jakarta.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Auto-generate primary key
    private int id;

    private String name;
    private boolean valid;

    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // ✅ Correct `mappedBy`
    private Person person;

    // Constructors
    public Passport() {}

    public Passport(String name, boolean valid) {
        this.name = name;
        this.valid = valid;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isValid() { return valid; }
    public void setValid(boolean valid) { this.valid = valid; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
