package nl.danielle.cattery.repository;

import nl.danielle.cattery.model.Catitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatitemRepository extends JpaRepository<Catitem, Long> {

}
