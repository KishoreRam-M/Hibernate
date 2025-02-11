package Restart.Hibernate.MappingTheory.service;

import Restart.Hibernate.MappingTheory.model.Passport;
import Restart.Hibernate.MappingTheory.model.Person;
import Restart.Hibernate.MappingTheory.repo.PersonRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // ✅ Ensures database consistency for all methods
public class Person_StudentService {
    private final PersonRepo personRepo; // ✅ Use `final` for best practice (constructor injection)

    // ✅ Constructor Injection (Best Practice)
    public Person_StudentService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    // ✅ Save a Person and their Passport
    public Person savePerson(Person person) {
        if (person.getPassport() != null) {
            Passport passport = person.getPassport();
            passport.setPerson(person); // ✅ Ensure bidirectional linking
        }
        return personRepo.save(person); // ✅ Saves both Person & Passport (CascadeType.ALL)
    }
}
