package fr.diginamic.tempsLibre.DTO;

import fr.diginamic.tempsLibre.enums.EmployeeStatus;
import fr.diginamic.tempsLibre.enums.Gender;
import fr.diginamic.tempsLibre.enums.Role;
import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
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