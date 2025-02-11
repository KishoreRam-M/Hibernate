package Restart.Hibernate.MappingTheory.service;

import Restart.Hibernate.MappingTheory.model.Laptop;
import Restart.Hibernate.MappingTheory.model.Student;
import Restart.Hibernate.MappingTheory.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLapService {  // Fixed class name
    @Autowired
    private StudentRepo repo;

    public Student addStudent(Student student) {
        if (student.getLaptops() != null) {
            for (Laptop laptop : student.getLaptops()) {
                laptop.setStudent(student); // Ensure bidirectional mapping
            }
        }
        return repo.save(student);
    }
}
