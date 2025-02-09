package Restart.Pratice_1.repo;

import Restart.Pratice_1.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapRepo extends JpaRepository<Laptop ,Integer> {
}
