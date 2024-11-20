package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.RTTEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RTTEmployerRepository extends JpaRepository<RTTEmployer, Long> {
}