package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.AbsenceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceTypeRepository extends JpaRepository<AbsenceType, Long> {
    AbsenceType findByLabel(String label);
}
