package fr.diginamic.tempsLibre.service;

import fr.diginamic.tempsLibre.DTO.EmployeeDTO;
import fr.diginamic.tempsLibre.mapper.EmployeeMapper;
import fr.diginamic.tempsLibre.model.Department;
import fr.diginamic.tempsLibre.model.Employee;
import fr.diginamic.tempsLibre.repository.DepartmentRepository;
import fr.diginamic.tempsLibre.repository.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;
    private final PasswordEncoder passwordEncoder;

    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository,
                           EmployeeMapper employeeMapper,
                           PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<EmployeeDTO> getAll() {

        List<EmployeeDTO> employees
                = employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDTO)
                .toList();

        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found");
        }

        return employees;
    }

    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return employeeMapper.toDTO(employee);
    }

    public EmployeeDTO findByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new RuntimeException("Employee not found with email: " + email);
        }
        return employeeMapper.toDTO(employee);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);

        String encodedPassword = passwordEncoder.encode(employeeDTO.getPassword());
        employee.setPassword(encodedPassword);

        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDTO(savedEmployee);    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        if (employeeDTO.getFirstname() != null) {
            employee.setFirstname(employeeDTO.getFirstname());
        }
        if (employeeDTO.getLastname() != null) {
            employee.setLastname(employeeDTO.getLastname());
        }
        if (employeeDTO.getEmail() != null) {
            employee.setEmail(employeeDTO.getEmail());
        }
        if (employeeDTO.getPhoneNumber() != null) {
            employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        }
        if (employeeDTO.getGender() != null) {
            employee.setGender(employeeDTO.getGender());
        }
        if (employeeDTO.getRole() != null) {
            employee.setRole(employeeDTO.getRole());
        }
        if (employeeDTO.getStatus() != null) {
            employee.setStatus(employeeDTO.getStatus());
        }
        if (employeeDTO.getRemainingLeaveDaysCounter() != null) {
            employee.setRemainingLeaveDaysCounter(employeeDTO.getRemainingLeaveDaysCounter());
        }

        if (employeeDTO.getDepartmentId() != null) {
            Department department = departmentRepository.findById(employeeDTO.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found with id: " + employeeDTO.getDepartmentId()));
            employee.setDepartment(department);
        }

        if (employeeDTO.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(employeeDTO.getPassword());
            employee.setPassword(encodedPassword);
        }
        
        Employee updatedEmployee = employeeRepository.save(employee);

        return employeeMapper.toDTO(updatedEmployee);
    }
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employee.setIsDeleted(true);
        employee.setDeletedAt(LocalDateTime.now());
        employeeRepository.save(employee);
    }
}
