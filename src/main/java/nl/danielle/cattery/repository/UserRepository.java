package nl.danielle.cattery.repository;

import nl.danielle.cattery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
