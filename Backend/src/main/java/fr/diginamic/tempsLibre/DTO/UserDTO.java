package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.enums.EmployeeStatus;
import fr.diginamic.tempsLibre.enums.Gender;
import fr.diginamic.tempsLibre.enums.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private Gender gender;
    private Role role;
    private EmployeeStatus status;
    private Integer remainingLeaveDaysCounter;
}