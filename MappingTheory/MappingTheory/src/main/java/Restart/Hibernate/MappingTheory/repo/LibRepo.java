package Restart.Hibernate.MappingTheory.repo;

import Restart.Hibernate.MappingTheory.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibRepo extends JpaRepository<Library,Integer> {
}
