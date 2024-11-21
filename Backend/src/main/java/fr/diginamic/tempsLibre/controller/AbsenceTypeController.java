package fr.diginamic.tempsLibre.controller;

import fr.diginamic.tempsLibre.DTO.AbsenceDTO;
import fr.diginamic.tempsLibre.DTO.AbsenceTypeDTO;
import fr.diginamic.tempsLibre.service.AbsenceService;
import fr.diginamic.tempsLibre.service.AbsenceTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/absences")
public class AbsenceTypeController {

    private final AbsenceTypeService absenceTypeService;

    public AbsenceTypeController(AbsenceTypeService absenceTypeService) {
        this.absenceTypeService = absenceTypeService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<AbsenceTypeDTO>> getAllAbsenceTypes() {
        try {
            List<AbsenceTypeDTO> absenceTypes = absenceTypeService.getAll();
            return ResponseEntity.ok(absenceTypes);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AbsenceTypeDTO> getAbsenceTypeById(@PathVariable Long id) {
        try {
            AbsenceTypeDTO absenceType = absenceTypeService.findById(id);
            return ResponseEntity.ok(absenceType);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/label/{label}")
    public ResponseEntity<AbsenceTypeDTO> getAbsenceTypeByLabel(@PathVariable String label) {
        try {
            AbsenceTypeDTO absenceType = absenceTypeService.findByLabel(label);
            return ResponseEntity.ok(absenceType);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<AbsenceTypeDTO> createAbsenceType(@RequestBody AbsenceTypeDTO absenceTypeDTO) {
        AbsenceTypeDTO createdAbsenceType = absenceTypeService.createAbsenceType(absenceTypeDTO);
        return ResponseEntity.ok(createdAbsenceType);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AbsenceTypeDTO> updateAbsenceType(@PathVariable Long id, @RequestBody AbsenceTypeDTO absenceTypeDTO) {
        try {
            AbsenceTypeDTO updatedAbsenceType = absenceTypeService.updateAbsenceType(id, absenceTypeDTO);
            return ResponseEntity.ok(updatedAbsenceType);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsenceType(@PathVariable Long id) {
        absenceTypeService.deleteAbsenceType(id);
        return ResponseEntity.ok().build();
    }
}
