package Restart.Pratice_1.service;

import Restart.Pratice_1.model.Laptop;
import Restart.Pratice_1.model.Student;
import Restart.Pratice_1.repo.LapRepo;
import Restart.Pratice_1.repo.StdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StdRepo studentRepo;

    @Autowired
    private LapRepo laptopRepo;

    // 🔥 Save Student with Laptop
    public Student saveStudentWithLaptop(Student student) {
        if (student.getLaptop() != null) {
            Laptop laptop = student.getLaptop();
            laptop.setStudent(student); // Ensure Laptop is linked to Student
        }
        return studentRepo.save(student); // Save Student (Cascade will save Laptop)
    }

    // 🔥 Get Student by ID (Including Laptop)
    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }

    // 🔥 Get All Students
    public Iterable<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}
