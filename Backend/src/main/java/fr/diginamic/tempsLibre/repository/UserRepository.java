package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
