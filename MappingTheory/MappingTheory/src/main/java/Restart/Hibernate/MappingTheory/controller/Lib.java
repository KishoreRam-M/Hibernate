package Restart.Hibernate.MappingTheory.controller;

import Restart.Hibernate.MappingTheory.model.Person;
import Restart.Hibernate.MappingTheory.service.Lib_StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Lib
{
@Autowired
    Lib_StudentService service;
    @PostMapping("/add")
    public Person toadd(@RequestBody Person p)
    {

        return  service.addStudent(p);
    }

}
