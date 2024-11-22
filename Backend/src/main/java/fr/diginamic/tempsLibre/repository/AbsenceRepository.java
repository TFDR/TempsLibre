package fr.diginamic.tempsLibre.repository;

import fr.diginamic.tempsLibre.model.Absence;
import fr.diginamic.tempsLibre.model.AbsenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    Absence findByEmployee_Id(Long userId);
    Absence findByAbsenceType_Id(Long absenceTypeId);
    Absence findByBeginDate(Date beginDate);
    Absence findByEndDate(Date endDate);
}
