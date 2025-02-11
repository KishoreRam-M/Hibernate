package Restart.Hibernate.MappingTheory.controller;

import Restart.Hibernate.MappingTheory.model.Person;
import Restart.Hibernate.MappingTheory.service.Person_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Person_Passport {
    @Autowired
    Person_StudentService service;
    @PostMapping("/add")
    public Person toadd( @RequestBody  Person p)
    {

        return  service.savePerson(p);
    }

}
