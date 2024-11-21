package fr.diginamic.tempsLibre.mapper;

import fr.diginamic.tempsLibre.DTO.AbsenceDTO;
import fr.diginamic.tempsLibre.DTO.UserDTO;
import fr.diginamic.tempsLibre.model.Absence;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapper {

    public Absence toEntity(AbsenceDTO absenceDTO) {
        Absence absence = new Absence();
        absence.setAbsenceType(absenceDTO.getAbsenceType());
        absence.setBeginDate(absenceDTO.getBeginDate());
        absence.setEndDate(absenceDTO.getEndDate());
        absence.setReason(absenceDTO.getReason());
        absence.setStatus(absenceDTO.getStatus());
        return absence;
    }

    public AbsenceDTO toDTO(Absence absence) {
        AbsenceDTO absenceDTO = new AbsenceDTO();
        absenceDTO.setAbsenceType(absence.getAbsenceType());
        absenceDTO.setBeginDate(absence.getBeginDate());
        absenceDTO.setEndDate(absence.getEndDate());
        absenceDTO.setReason(absence.getReason());
        absenceDTO.setStatus(absence.getStatus());
        return absenceDTO;
    }
}