package Restart.Hibernate.MappingTheory.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Name {
    private  String firstname;

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    private String middlename;
    private String lastname;
    public  Name()
    {}
    public  Name(String f, String m, String l)
    {
        this.firstname=f;
        this.middlename=m;
        this.lastname=l;
    }
}
