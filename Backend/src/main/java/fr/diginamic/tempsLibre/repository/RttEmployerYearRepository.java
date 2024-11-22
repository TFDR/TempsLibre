package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.RttEmployerYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RttEmployerYearRepository extends JpaRepository<RttEmployerYear, Long> {
}
