package Restart.Hibernate.MappingTheory.repo;

import Restart.Hibernate.MappingTheory.model.LibStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibStudentRepo extends JpaRepository<LibStudent , Integer> {
}
