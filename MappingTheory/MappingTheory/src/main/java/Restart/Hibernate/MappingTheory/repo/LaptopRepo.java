package Restart.Hibernate.MappingTheory.repo;

import Restart.Hibernate.MappingTheory.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Integer> {
}
