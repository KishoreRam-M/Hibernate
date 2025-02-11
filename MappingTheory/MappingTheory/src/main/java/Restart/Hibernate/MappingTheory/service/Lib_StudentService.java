package Restart.Hibernate.MappingTheory.service;

import Restart.Hibernate.MappingTheory.model.LibStudent;
import Restart.Hibernate.MappingTheory.model.Library;
import Restart.Hibernate.MappingTheory.repo.LibRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Lib_StudentService {

    @Autowired
    private LibRepo repo;

    public LibStudent addStudent(LibStudent student) {
        if (student.getLibraries() != null) {
            for (Library library : student.getLibraries()) {
                library.getStudents().add(student); // Ensure bidirectional mapping
            }
        }
        return repo.save(student);
    }
}
