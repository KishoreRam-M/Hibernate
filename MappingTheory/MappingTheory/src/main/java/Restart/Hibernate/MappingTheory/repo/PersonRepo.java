package Restart.Hibernate.MappingTheory.repo;

import Restart.Hibernate.MappingTheory.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo  extends JpaRepository<Person,Integer> {

}
