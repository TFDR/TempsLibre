package fr.diginamic.tempsLibre.controller;

import fr.diginamic.tempsLibre.DTO.DepartmentDTO;
import fr.diginamic.tempsLibre.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        try {
            List<DepartmentDTO> departments = departmentService.getAll();
            return ResponseEntity.ok(departments);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
        try {
            DepartmentDTO department = departmentService.findById(id);
            return ResponseEntity.ok(department);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO createdDepartment = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.ok(createdDepartment);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
            DepartmentDTO updatedDepartment = departmentService.(id, departmentDTO);
            return ResponseEntity.ok(updatedDepartment);
    }
}
