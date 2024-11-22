package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.enums.EmployeeStatus;
import fr.diginamic.tempsLibre.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private String name;
}