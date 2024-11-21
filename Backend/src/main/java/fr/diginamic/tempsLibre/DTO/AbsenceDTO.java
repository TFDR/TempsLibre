package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.enums.AbsenceStatus;
import fr.diginamic.tempsLibre.model.AbsenceType;
import lombok.Data;

import java.util.Date;

@Data
public class AbsenceDTO {
    private Long id;
    private AbsenceType absenceType;
    private Date beginDate;
    private Date endDate;
    private String reason;
    private AbsenceStatus status;

}