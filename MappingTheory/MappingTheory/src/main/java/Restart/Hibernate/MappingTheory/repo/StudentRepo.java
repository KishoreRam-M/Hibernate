package Restart.Hibernate.MappingTheory.repo;

import Restart.Hibernate.MappingTheory.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
