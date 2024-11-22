package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.enums.EmployeeStatus;
import fr.diginamic.tempsLibre.enums.Gender;
import fr.diginamic.tempsLibre.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private Gender gender;

    @Builder.Default
    private Role role = Role.EMPLOYEE;
    private EmployeeStatus status;

    @Builder.Default
    private Integer remainingLeaveDaysCounter = 25;
}