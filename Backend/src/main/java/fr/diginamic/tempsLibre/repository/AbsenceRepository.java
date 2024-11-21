package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    Absence findByAbsenceType(String absenceType);
}
