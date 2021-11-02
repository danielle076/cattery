package nl.danielle.cattery.repository;

import nl.danielle.cattery.model.Kitten;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KittenRepository extends JpaRepository<Kitten, Long> {
}
