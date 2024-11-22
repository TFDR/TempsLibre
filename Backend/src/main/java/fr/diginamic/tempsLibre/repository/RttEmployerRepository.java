package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.RttEmployer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface RttEmployerRepository extends JpaRepository<RttEmployer, Long> {
    RttEmployer findByDate(LocalDate date);
}