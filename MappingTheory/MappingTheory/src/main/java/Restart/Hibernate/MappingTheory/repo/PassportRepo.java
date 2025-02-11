package Restart.Hibernate.MappingTheory.repo;

import Restart.Hibernate.MappingTheory.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepo extends JpaRepository<Passport,Integer> {
}
