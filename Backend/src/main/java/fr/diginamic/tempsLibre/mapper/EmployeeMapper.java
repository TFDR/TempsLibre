package fr.diginamic.tempsLibre.mapper;

import fr.diginamic.tempsLibre.DTO.EmployeeDTO;
import fr.diginamic.tempsLibre.model.Department;
import fr.diginamic.tempsLibre.model.Employee;
import fr.diginamic.tempsLibre.repository.DepartmentRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    private final DepartmentRepository departmentRepository;

    public EmployeeMapper(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPassword(employeeDTO.getPassword());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setGender(employeeDTO.getGender());
        employee.setRole(employeeDTO.getRole());
        employee.setStatus(employeeDTO.getStatus());
        employee.setRemainingLeaveDaysCounter(employeeDTO.getRemainingLeaveDaysCounter());

        if (employeeDTO.getDepartmentId() != null) {
            Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found with id: " + employeeDTO.getDepartmentId()));
            employee.setDepartment(department);
        }

        return employee;
    }

    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstname(employee.getFirstname());
        employeeDTO.setLastname(employee.getLastname());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setGender(employee.getGender());
        employeeDTO.setRole(employee.getRole());
        employeeDTO.setStatus(employee.getStatus());
        employeeDTO.setRemainingLeaveDaysCounter(employee.getRemainingLeaveDaysCounter());

        if (employee.getDepartment() != null) {
            employeeDTO.setDepartmentId(employee.getDepartment().getId());
        }

        return employeeDTO;
    }
}