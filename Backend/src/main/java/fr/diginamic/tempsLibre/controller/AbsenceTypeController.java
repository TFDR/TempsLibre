package fr.diginamic.tempsLibre.controller;

import fr.diginamic.tempsLibre.DTO.AbsenceTypeDTO;
import fr.diginamic.tempsLibre.service.AbsenceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/absenceTypes")
public class AbsenceTypeController {

    @Autowired
    private AbsenceTypeService absenceTypeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AbsenceTypeDTO>> getAllAbsenceTypes() {
        try {
            List<AbsenceTypeDTO> absenceTypesDTO = absenceTypeService.getAll();
            return ResponseEntity.ok(absenceTypesDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AbsenceTypeDTO> getAbsenceTypeById(@PathVariable Long id) {
        try {
            AbsenceTypeDTO absenceTypeDTO = absenceTypeService.findById(id);
            return ResponseEntity.ok(absenceTypeDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping(path = "/label/{label}")
    public ResponseEntity<AbsenceTypeDTO> getAbsenceTypeByLabel(@PathVariable String label) {
        try {
            AbsenceTypeDTO absenceTypeDTO = absenceTypeService.findByLabel(label);
            return ResponseEntity.ok(absenceTypeDTO);
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
        try {
            absenceTypeService.deleteAbsenceType(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
