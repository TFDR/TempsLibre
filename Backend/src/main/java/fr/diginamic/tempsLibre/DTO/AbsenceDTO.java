package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.enums.AbsenceStatus;
import fr.diginamic.tempsLibre.model.AbsenceType;
import fr.diginamic.tempsLibre.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbsenceDTO {
    private Date beginDate;
    private Date endDate;
    private String reason;
    private AbsenceStatus status;
    private AbsenceType absenceType;
    private User employee;

}