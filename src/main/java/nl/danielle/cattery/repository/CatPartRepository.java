package nl.danielle.cattery.repository;

import nl.danielle.cattery.model.Catpart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatPartRepository extends JpaRepository<Catpart, Long> {
}
