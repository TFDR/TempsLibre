package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.RttEmployer;
import fr.diginamic.tempsLibre.model.RttEmployerYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RttEmployerYearRepository extends JpaRepository<RttEmployerYear, Long> {
}
