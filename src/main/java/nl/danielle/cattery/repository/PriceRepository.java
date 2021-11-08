package nl.danielle.cattery.repository;

import nl.danielle.cattery.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
