package fr.diginamic.tempsLibre.configs;

import fr.diginamic.tempsLibre.enums.EmployeeStatus;
import fr.diginamic.tempsLibre.enums.Gender;
import fr.diginamic.tempsLibre.enums.Role;
import fr.diginamic.tempsLibre.model.Department;
import fr.diginamic.tempsLibre.model.Employee;
import fr.diginamic.tempsLibre.repository.DepartmentRepository;
import fr.diginamic.tempsLibre.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

/*
@Component
*/
public class InitDataLoader {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public InitDataLoader(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

/*
    @PostConstruct
*/
    public void initData() {
        Department itDepartment = new Department();
        itDepartment.setName("IT Department");

        Department hrDepartment = new Department();
        hrDepartment.setName("HR Department");

        departmentRepository.saveAll(List.of(itDepartment, hrDepartment));

        Employee employee1 = Employee.builder()
                .firstname("John")
                .lastname("Doe")
                .email("john.doe@example.com")
                .password("password123")
                .phoneNumber("1234567890")
                .gender(Gender.MALE)
                .role(Role.EMPLOYEE)
                .status(EmployeeStatus.PRESENT)
                .department(itDepartment)
                .build();

        Employee employee2 = Employee.builder()
                .firstname("Alice")
                .lastname("Smith")
                .email("alice.smith@example.com")
                .password("password123")
                .phoneNumber("0987654321")
                .gender(Gender.FEMALE)
                .role(Role.EMPLOYEE)
                .status(EmployeeStatus.PRESENT)
                .department(hrDepartment)
                .build();

        Employee manager1 = Employee.builder()
                .firstname("Jane")
                .lastname("Doe")
                .email("jane.doe@example.com")
                .password("password123")
                .phoneNumber("1122334455")
                .gender(Gender.FEMALE)
                .role(Role.MANAGER)
                .status(EmployeeStatus.PRESENT)
                .department(itDepartment)
                .build();

        Employee manager2 = Employee.builder()
                .firstname("Mark")
                .lastname("Johnson")
                .email("mark.johnson@example.com")
                .password("password123")
                .phoneNumber("6677889900")
                .gender(Gender.MALE)
                .role(Role.MANAGER)
                .status(EmployeeStatus.PRESENT)
                .department(hrDepartment)
                .build();

        employeeRepository.saveAll(List.of(employee1, employee2, manager1, manager2));

        System.out.println("Sample data loaded successfully.");
    }
}
