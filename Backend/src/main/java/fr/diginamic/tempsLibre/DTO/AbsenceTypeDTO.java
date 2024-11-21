package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.enums.AbsenceStatus;
import fr.diginamic.tempsLibre.model.AbsenceType;
import lombok.Data;

import java.util.Date;

@Data
public class AbsenceTypeDTO {
    private Long id;
    private String label;

}