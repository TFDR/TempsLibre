package fr.diginamic.tempsLibre.service;

import fr.diginamic.tempsLibre.DTO.DepartmentDTO;
import fr.diginamic.tempsLibre.DTO.EmployeeDTO;
import fr.diginamic.tempsLibre.mapper.DepartmentMapper;
import fr.diginamic.tempsLibre.mapper.EmployeeMapper;
import fr.diginamic.tempsLibre.model.Department;
import fr.diginamic.tempsLibre.model.Employee;
import fr.diginamic.tempsLibre.repository.DepartmentRepository;
import fr.diginamic.tempsLibre.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }
    
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = departmentMapper.toEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDTO(savedDepartment);
    }
    
    public List<DepartmentDTO> getAll() {
        List<DepartmentDTO> departments
                = departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDTO)
                .toList();

        if (departments.isEmpty()) {
            throw new RuntimeException("No departments found");
        }

        return departments;
    }

    public DepartmentDTO findById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
        return departmentMapper.toDTO(department);
    }

    public DepartmentDTO findByName(String name) {
        Department department = departmentRepository.findByName(name);
        if (department == null) {
            throw new RuntimeException("Department not found with name: " + name);
        }
        return departmentMapper.toDTO(department);
    }

}
