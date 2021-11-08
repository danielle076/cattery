package nl.danielle.cattery.repository;

import nl.danielle.cattery.model.Catpart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatpartRepository extends JpaRepository<Catpart, Long> {

}
