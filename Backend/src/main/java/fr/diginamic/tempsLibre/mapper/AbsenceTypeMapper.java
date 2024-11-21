package fr.diginamic.tempsLibre.mapper;

import fr.diginamic.tempsLibre.DTO.AbsenceTypeDTO;
import fr.diginamic.tempsLibre.model.AbsenceType;
import org.springframework.stereotype.Component;

@Component
public class AbsenceTypeMapper {

    public AbsenceType toEntity(AbsenceTypeDTO absenceTypeDTO) {
        AbsenceType absenceType = new AbsenceType();
        absenceType.setLabel(absenceTypeDTO.getLabel());
        return absenceType;
    }

    public AbsenceTypeDTO toDTO(AbsenceType absenceType) {
        AbsenceTypeDTO absenceTypeDTO = new AbsenceTypeDTO();
        absenceTypeDTO.setLabel(absenceType.getLabel());
        return absenceTypeDTO;
    }
}