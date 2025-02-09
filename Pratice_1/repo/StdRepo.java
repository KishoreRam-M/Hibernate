package Restart.Pratice_1.repo;

import Restart.Pratice_1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StdRepo extends JpaRepository<Student,Integer> {
}
