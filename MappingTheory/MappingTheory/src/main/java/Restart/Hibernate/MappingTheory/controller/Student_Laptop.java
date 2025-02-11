package Restart.Hibernate.MappingTheory.controller;

import Restart.Hibernate.MappingTheory.model.Student;
import Restart.Hibernate.MappingTheory.service.StudentLapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_Laptop {
@Autowired
    StudentLapService service;
    public Student toadd(String string)
    {
return  service.addStudent(string);
    }


}
